package net.skhu;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button button = findViewById(R.id.button);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText_loginId = findViewById(R.id.editText_loginId);
                String loginId = editText_loginId.getText().toString();
                //getText의 리턴값은 String이 아니다. 따라서 toString으로 변환 해줘야한다.
                if (isEmptyOrWhiteSpace(loginId))//로그인 창이 비어있는 경운
                    editText_loginId.setError("로그인 아이디를 입력하세요");

                EditText editText_password = findViewById(R.id.editText_password);
                String password = editText_password.getText().toString();
                if (isEmptyOrWhiteSpace(password))//비밀번호 창이 비어있는경우
                    editText_password.setError("비밀번호를 입력하세요");

                EditText editText_password2 = findViewById(R.id.editText_password2);
                String password2 = editText_password2.getText().toString();
                if (password.equals(password2) == false)//비밀번호와 비밀번호 확인이 일치하는지 확인
                    editText_password2.setError("비밀번호가 일치하지 않습니다");

                EditText editText_email = findViewById(R.id.editText_email);
                String email = editText_email.getText().toString();

                // 회원 가입 데이터를 서버에 전송하는 코드를 구현해야 함.

                String msg = "회원가입 성공: " + loginId + " " + email;
                Toast.makeText(SignupActivity.this, msg, Toast.LENGTH_LONG).show();
                //일정시간 화면에 띄우기 ex "회원가입 성공 tibrong3 t01091880485@gmail.com "
                //이런 식으로 창이 뜨게 된다.
            }
        };
        button.setOnClickListener(listener);
    }

    static boolean isEmptyOrWhiteSpace(String s) { //새로운 메소드
        if (s == null) return true;
        return s.trim().length() == 0;
    }
}

