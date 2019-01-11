//import android.util.Log;
//import android.view.View;
//import android.widget.CheckBox;
//import android.widget.LinearLayout;
//import android.widget.RadioButton;
//import android.widget.Toast;
//
//import com.example.xxpc.quizzapp.R;
//
//public class xxx {
//    View viewByPosition = recyclerView.getLayoutManager().findViewByPosition(i);
//    textView = viewByPosition.findViewById(R.id.txtType);
//    radioLayout = viewByPosition.findViewById(R.id.radioLayout);
//    editText = viewByPosition.findViewById(R.id.EditLayout);
//    int visibilityRadio = radioLayout.getVisibility();
//    RadioButton radioButton_A = viewByPosition.findViewById(R.id.radio_A);
//    RadioButton radioButton_B = viewByPosition.findViewById(R.id.radio_B);
//    RadioButton radioButton_C = viewByPosition.findViewById(R.id.radio_C);
//            if (visibilityRadio == View.VISIBLE) {
//        if (radioButton_A.isChecked() == true) {
//            valueOfRadioButton = "a";
//            Log.e("e",valueOfRadioButton);
//        }
//        if (radioButton_B.isChecked() == true) {
//            valueOfRadioButton = "b";
//            Log.e("e",valueOfRadioButton);
//        }
//        if (radioButton_C.isChecked() == true) {
//            valueOfRadioButton = "c";
//            Log.e("e",valueOfRadioButton);
//        }
//        String s = answerArray[i];
//        if (valueOfRadioButton.equals(s)) {
//            textView.setText("1");
//        } else {
//            textView.setText("0");
//        }
//        valueOfRadioButton = "a0";
//        Log.e("ee",valueOfRadioButton);
//    }
//
//    LinearLayout checkLayout = viewByPosition.findViewById(R.id.checkLayout);
//    int visibilityCheck = checkLayout.getVisibility();
//            if (visibilityCheck == View.VISIBLE) {
//        CheckBox checkA = viewByPosition.findViewById(R.id.check_A);
//        CheckBox checkB = viewByPosition.findViewById(R.id.check_B);
//        CheckBox checkC = viewByPosition.findViewById(R.id.check_C);
//        CheckBox checkD = viewByPosition.findViewById(R.id.check_D);
//        if (checkA.isChecked() == true) {
//            valueOfChek[0] = "a";
//            Log.e("a", valueOfChek[0] + "");
//        }
//        if (checkB.isChecked() == true) {
//            valueOfChek[1] = "b";
//            Log.e("a", valueOfChek[1] + "");
//        }
//        if (checkC.isChecked() == true) {
//            valueOfChek[2] = "c";
//            Log.e("a", valueOfChek[2] + "");
//        }
//        if (checkD.isChecked() == true) {
//            valueOfChek[3] = "d";
//            Log.e("a", valueOfChek[3] + "");
//        }
//        sumValueOfCheck = valueOfChek.toString();
//        Log.e("abcxx", sumValueOfCheck);
//        sumValueOfCheck = "";
//        for (int t = 0; t < valueOfChek.length; t++) {
//            sumValueOfCheck += valueOfChek[t];
//        }
//        Log.e("abcyy", sumValueOfCheck);
//        if (sumValueOfCheck.equals(answerArray[i])) {
//            textView.setText("1");
//        } else {
//            textView.setText("0");
//        }
//    }
//
//
//    text= String.valueOf(editText.getText());
//    int visibilityEdit = editText.getVisibility();
//            if (visibilityEdit == View.VISIBLE) {
//        if (text.equals(answerArray[i])) {
//            textView.setText("1");
//        } else {
//            textView.setText("0");
//        }
//    }
//            Log.e("1e"+i,answerArray[i]);
//
//            Toast.makeText(this, textView.getText()+" "+i, Toast.LENGTH_SHORT).show();
//
//}
