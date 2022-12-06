package com.rendu.riskcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rendu.riskcalculator.databinding.ActivityCalcBinding;

public class CalcActivity extends AppCompatActivity {

    private ActivityCalcBinding binding;
    int radioStatus = 0;

    public void longRadio(View view){
        radioStatus=1;

    }
    public void shortRadio(View view){
        radioStatus=2;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalcBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }

    public void viewMargin(View view) {
        double capitalVal = 0, riskVal = 0, atrVal = 0, entryVal = 0, divisorVal = 0, leverageVal = 0;
        int i = 0;

        if (binding.editTextNumber.getText().toString() != null && binding.editTextNumber.getText().toString().length() != 0) {
            String captValue = binding.editTextNumber.getText().toString();
            capitalVal = Double.parseDouble(captValue);
            i++;
            if (i==1 && binding.editTextNumber2.getText().toString()!=null && binding.editTextNumber2.getText().toString().length() != 0) {
                String riskValue = binding.editTextNumber2.getText().toString();
                riskVal = Double.parseDouble(riskValue);
                i++;
                if (i==2 && binding.editTextNumber4.getText().toString()!=null && binding.editTextNumber4.getText().toString().length() != 0) {
                    String atrValue = binding.editTextNumber4.getText().toString();
                    atrVal = Double.parseDouble(atrValue);
                    i++;
                    if (i==3 && binding.editTextNumber3.getText().toString()!=null && binding.editTextNumber3.getText().toString().length() != 0) {
                        String entryValue = binding.editTextNumber3.getText().toString();
                        entryVal = Double.parseDouble(entryValue);
                        i++;
                        if (i==4 && binding.editTextNumber5.getText().toString()!=null && binding.editTextNumber5.getText().toString().length() != 0) {
                            String divisorValue = binding.editTextNumber5.getText().toString();
                            divisorVal = Double.parseDouble(divisorValue);
                            i++;
                            if (i==5 && binding.editTextNumber6.getText().toString()!=null && binding.editTextNumber6.getText().toString().length() != 0) {
                                String leverageValue = binding.editTextNumber6.getText().toString();
                                leverageVal = Double.parseDouble(leverageValue);
                                i++;
                                if (i==6) {
                                    double a = capitalVal * (riskVal / 100);
                                    double a2 = atrVal / divisorVal;
                                    double b = a / a2;
                                    double c = b * entryVal;
                                    double marginVal = c / leverageVal;
                                    double stopLossVal = 0;
                                    double tpVal = 0;
                                    double sizeVal = 0;
                                    if (radioStatus == 0) {
                                        Toast.makeText(this, "Please choose Long or Short", Toast.LENGTH_SHORT).show();
                                    } else if (radioStatus == 1) {
                                        stopLossVal = entryVal - a2;
                                        tpVal = entryVal + a2;
                                        sizeVal =(leverageVal *marginVal)/entryVal; ;

                                        binding.textView3.setText(String.valueOf(marginVal));
                                        binding.textView9.setText(String.valueOf(stopLossVal));
                                        binding.textView14.setText(String.valueOf(tpVal));
                                        binding.textView15.setText(String.valueOf(sizeVal));

                                        binding.textView2.setVisibility(View.VISIBLE);
                                        binding.textView3.setVisibility(View.VISIBLE);
                                        binding.textView12.setVisibility(View.VISIBLE);
                                        binding.textView13.setVisibility(View.VISIBLE);
                                        binding.textView4.setVisibility(View.VISIBLE);
                                        binding.textView9.setVisibility(View.VISIBLE);
                                        binding.textView14.setVisibility(View.VISIBLE);
                                        binding.textView15.setVisibility(View.VISIBLE);
                                    } else {
                                        stopLossVal = entryVal + a2;
                                        tpVal = entryVal - a2;
                                        sizeVal =(leverageVal *marginVal)/entryVal;

                                        binding.textView3.setText(String.valueOf(marginVal));
                                        binding.textView9.setText(String.valueOf(stopLossVal));
                                        binding.textView14.setText(String.valueOf(tpVal));
                                        binding.textView15.setText(String.valueOf(sizeVal));

                                        binding.textView2.setVisibility(View.VISIBLE);
                                        binding.textView3.setVisibility(View.VISIBLE);
                                        binding.textView12.setVisibility(View.VISIBLE);
                                        binding.textView13.setVisibility(View.VISIBLE);
                                        binding.textView4.setVisibility(View.VISIBLE);
                                        binding.textView9.setVisibility(View.VISIBLE);
                                        binding.textView14.setVisibility(View.VISIBLE);
                                        binding.textView15.setVisibility(View.VISIBLE);
                                    }
                                }
                                else {
                                    Toast.makeText(this,"An Error has occured, Please try again",Toast.LENGTH_SHORT).show();
                                }



                            }else {
                                Toast.makeText(this,"Leverage Not filled",Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(this,"Divisor Not filled",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(this,"Entry Not filled",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(this,"Price Change Not filled",Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(this,"Risk Not filled",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Capital Not filled", Toast.LENGTH_SHORT).show();
        }
    }
}


