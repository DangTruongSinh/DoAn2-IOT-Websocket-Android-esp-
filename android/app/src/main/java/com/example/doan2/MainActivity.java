package com.example.doan2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okio.ByteString;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private TextView txtNhietDo;
    private Switch switchQuat;
    private ImageView imgDen1;
    private Switch switchDen1;
    private ImageView imgDen2;
    private Switch switchDen2;
    private TextView txtCheDo;
    private OkHttpClient client;
    WebSocket ws;
    ObjectMapper mapper = new ObjectMapper();
    public void commoSendStatusSwitch(boolean status, String name)
    {
        ThietBi thietBi;
        if(!status)
            thietBi = new ThietBi(name,false);
        else
            thietBi = new ThietBi(name,true);
        try {
            String value  = mapper.writeValueAsString(thietBi);
            ws.send(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public void commoSendStatusImg(boolean status, String name)
    {
        ThietBi thietBi;
        if(status)
            thietBi = new ThietBi(name,false);
        else
            thietBi = new ThietBi(name,true);
        try {
            String value  = mapper.writeValueAsString(thietBi);
            ws.send(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imgDen1)
            commoSendStatusImg(switchDen1.isChecked(),"den1");
        else if(view.getId() == R.id.imgDen2)
            commoSendStatusImg(switchDen1.isChecked(),"den2");

    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if(compoundButton.getId() == R.id.switchDen1)
            commoSendStatusSwitch(b,"den1");
        else if(compoundButton.getId() == R.id.switchDen2)
            commoSendStatusSwitch(b,"den2");
        else if(compoundButton.getId() == R.id.switchQuat)
            commoSendStatusSwitch(b,"quat");
    }


    private final class EchoWebSocketListener extends WebSocketListener {
        private static final int NORMAL_CLOSURE_STATUS = 1000;
        @Override
        public void onMessage(WebSocket webSocket, String text) {
            output(text);
        }
        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(NORMAL_CLOSURE_STATUS, null);
            output("Closing : " + code + " / " + reason);
        }
        @Override
        public void onFailure(WebSocket webSocket, Throwable t, Response response) {
            output("Error : " + t.getMessage());
        }
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            ThietBi thietBi = (ThietBi) msg.obj;
            if(thietBi.getName().equals("den1"))
            {
                if(thietBi.isStatus())
                {
                    imgDen1.setImageResource(R.drawable.ledsang);
                    switchDen1.setChecked(true);
                }
                else
                {
                    imgDen1.setImageResource(R.drawable.ledtat);
                    switchDen1.setChecked(false);
                }
            }
            else if(thietBi.getName().equals("den2"))
            {
                if(thietBi.isStatus())
                {
                    imgDen2.setImageResource(R.drawable.ledsang);
                    switchDen2.setChecked(true);
                }
                else
                {
                    imgDen2.setImageResource(R.drawable.ledtat);
                    switchDen2.setChecked(false);
                }
            }
            else if(thietBi.getName().equals("quat"))
            {
                if(thietBi.isStatus())
                    switchQuat.setChecked(true);
                else
                    switchQuat.setChecked(false);
            }
            else if(thietBi.getName().equals("nhietdo"))
                txtNhietDo.setText(thietBi.getNhietdo());
            else if(thietBi.getName().equals("chedo"))
            {
                if(thietBi.isStatus())
                    txtCheDo.setText("AUTO");
                else
                    txtCheDo.setText("MANUAL");
            }
        }
    };
    private void output(final String txt) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {

                try {
                    Log.d("message",txt);

                    if(txt.startsWith("["))
                    {
                        ThietBi[] list = mapper.readValue(txt,ThietBi[].class);
                        for(ThietBi x: list)
                        {
                            Message message = new Message();
                            message.obj = x;
                            handler.sendMessage(message);
                        }
                    }
                    else
                    {
                        ThietBi thietBi = mapper.readValue(txt,ThietBi.class);
                        Message message = new Message();
                        message.obj = thietBi;
                        handler.sendMessage(message);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtCheDo = findViewById(R.id.txtCheDo);
        txtNhietDo = findViewById(R.id.txtNhietDo);
        switchQuat = findViewById(R.id.switchQuat);
        switchDen1 = findViewById(R.id.switchDen1);
        switchDen2 = findViewById(R.id.switchDen2);
        imgDen1 = findViewById(R.id.imgDen1);
        imgDen2 = findViewById(R.id.imgDen2);
        Log.d("message", "cccc");
        client = new OkHttpClient();
        initConnect();
        imgDen1.setOnClickListener(this);
        switchDen1.setOnCheckedChangeListener(this);
        imgDen2.setOnClickListener(this);
        switchDen2.setOnCheckedChangeListener(this);
        switchQuat.setOnCheckedChangeListener(this);
    }

    private void initConnect() {
        Request request = new Request.Builder().url("ws://192.168.1.105:8080/realtime-data").build();
        EchoWebSocketListener listener = new EchoWebSocketListener();
        ws = client.newWebSocket(request, listener);
        client.dispatcher().executorService().shutdown();
    }

}
