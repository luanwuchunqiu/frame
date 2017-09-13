package com.example.zyt.frame.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zyt.frame.R;
import com.example.zyt.frame.paper.common.util.ConvertUtils;
import com.example.zyt.frame.paper.pickertask.AddressPickTask;
import com.example.zyt.frame.paper.wheelpicker.entity.City;
import com.example.zyt.frame.paper.wheelpicker.entity.County;
import com.example.zyt.frame.paper.wheelpicker.entity.Province;
import com.example.zyt.frame.paper.wheelpicker.picker.DatePicker;
import com.example.zyt.frame.paper.wheelpicker.picker.NumberPicker;
import com.example.zyt.frame.paper.wheelpicker.picker.OptionPicker;
import com.example.zyt.frame.paper.wheelpicker.widget.WheelView;


/**
 * Created by zyt on 2017/8/21.
 */

public class UserDataActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout genderLayout;
    private LinearLayout userHeightLayout;
    private LinearLayout userWeightLayout;
    private LinearLayout userAddressLayout;
    private LinearLayout userBirthdayLayout;
    private LinearLayout userSportsYearLayout;
    
    
    private  TextView    genderTextView;
    private  TextView userHeightTextView;
    private  TextView userWeightTextView;
    private  TextView userAddressTextView;
    private  TextView userBirthdayTextView;
    private  TextView userSportsYearTextView;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        genderLayout = (LinearLayout) findViewById(R.id.gender);
        userHeightLayout = (LinearLayout) findViewById(R.id.layout_user_height);
        userWeightLayout = (LinearLayout) findViewById(R.id.layout_user_weight);
        userAddressLayout = (LinearLayout) findViewById(R.id.layout_user_address);
        userBirthdayLayout = (LinearLayout) findViewById(R.id.layout_user_birthday);
        userSportsYearLayout = (LinearLayout) findViewById(R.id.layout_user_sports_year);

        genderTextView = (TextView) findViewById(R.id.genderTextView) ;
        userHeightTextView = (TextView) findViewById(R.id.text_view_user_height);
        userWeightTextView = (TextView) findViewById(R.id.text_view_user_weight);
        userAddressTextView= (TextView) findViewById(R.id.text_view_user_address);
        userBirthdayTextView = (TextView) findViewById(R.id.text_view_user_birthday);
        userSportsYearTextView = (TextView) findViewById(R.id.text_view_user_sports_year);
       
        genderLayout.setOnClickListener(this);
        userHeightLayout.setOnClickListener(this);
        userWeightLayout.setOnClickListener(this);
        userAddressLayout.setOnClickListener(this);
        userBirthdayLayout.setOnClickListener(this);
        userSportsYearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.gender:{
                OptionPicker picker = new OptionPicker(this, new String[]{
                        "男", "女"
                });
                picker.setCanceledOnTouchOutside(false);
                picker.setDividerRatio(WheelView.DividerConfig.FILL);
                picker.setShadowColor(Color.RED, 40);
                picker.setSelectedIndex(1);
                picker.setCycleDisable(true);
                picker.setTextSize(11);
                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int index, String item) {
                        genderTextView.setText(item);

                    }
                });
                picker.show();
            }break;

            case R.id.layout_user_height:{
                NumberPicker picker = new NumberPicker(this);
                picker.setWidth(picker.getScreenWidthPixels() );//选择器的宽度
                picker.setCycleDisable(false);
                picker.setDividerVisible(false);
                picker.setOffset(2);//偏移量
                picker.setRange(145, 200, 1);//数字范围
                picker.setSelectedItem(172);
                picker.setLabel("厘米");
                picker.setOnNumberPickListener(new NumberPicker.OnNumberPickListener() {
                    @Override
                    public void onNumberPicked(int index, Number item) {
                        userHeightTextView.setText(item.intValue()+"");
                    }
                });
                picker.show();
            }break;
            case R.id.layout_user_weight:{
                NumberPicker picker = new NumberPicker(this);
                picker.setWidth(picker.getScreenWidthPixels() );//选择器的宽度
                picker.setCycleDisable(false);
                picker.setDividerVisible(false);
                picker.setOffset(2);//偏移量
                picker.setRange(30, 200, 1);//数字范围
                picker.setSelectedItem(50);
                picker.setLabel("kg");
                picker.setOnNumberPickListener(new NumberPicker.OnNumberPickListener() {
                    @Override
                    public void onNumberPicked(int index, Number item) {
                        userWeightTextView.setText(item.intValue()+"");
                    }
                });
                picker.show();
            }break;
            case R.id.layout_user_address:{

                AddressPickTask task = new AddressPickTask(this);
                task.setHideProvince(false);
                task.setHideCounty(false);
                task.setCallback(new AddressPickTask.Callback() {
                    @Override
                    public void onAddressInitFailed() {
                        showToast("数据初始化失败");
                    }

                    @Override
                    public void onAddressPicked(Province province, City city, County county) {
                        if (county == null) {
                            userAddressTextView.setText(province.getName()+" "+city.getName());
                        } else {
                            userAddressTextView.setText(province.getName()+" "+city.getName()+" "+county.getName());
                        }
                    }
                });
                task.execute("贵州", "毕节", "纳雍");

            }break;
            case R.id.layout_user_birthday:{
                final DatePicker picker = new DatePicker(this);
                picker.setCanceledOnTouchOutside(true);
                picker.setUseWeight(true);
                picker.setTopPadding(ConvertUtils.toPx(this, 10));
                picker.setRangeEnd(2111, 1, 11);
                picker.setRangeStart(2016, 8, 29);
                picker.setSelectedItem(2050, 10, 14);
                picker.setResetWhileWheel(false);
                picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
                    @Override
                    public void onDatePicked(String year, String month, String day) {
                        userBirthdayTextView.setText(year+"-"+month+"-"+day);
                    }
                });
                picker.setOnWheelListener(new DatePicker.OnWheelListener() {
                    @Override
                    public void onYearWheeled(int index, String year) {
                        picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onMonthWheeled(int index, String month) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
                    }

                    @Override
                    public void onDayWheeled(int index, String day) {
                        picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
                    }
                });
                picker.show();
            }break;
            case R.id.layout_user_sports_year:{
                NumberPicker picker = new NumberPicker(this);
                picker.setWidth(picker.getScreenWidthPixels() );//选择器的宽度
                picker.setCycleDisable(false);
                picker.setDividerVisible(false);
                picker.setOffset(2);//偏移量
                picker.setRange(1995, 2017, 1);//数字范围
                picker.setSelectedItem(2017);
                picker.setLabel("年");
                picker.setOnNumberPickListener(new NumberPicker.OnNumberPickListener() {
                    @Override
                    public void onNumberPicked(int index, Number item) {
                        userSportsYearTextView.setText(2017-item.intValue()+"");
                    }
                });
                picker.show();
            }break;
        }
    }
private void showToast(String tag) {
    Toast.makeText(this,tag,Toast.LENGTH_SHORT).show();
    }

}
