package com.caijy.jhwei.bv.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.caijy.jhwei.bv.R;

/**
 * Created by Administrator on 2016/4/26.
 */
public class ProjectItemView extends RelativeLayout {

    public ProjectItemView(Context context) {
        this(context, null);
    }

    public ProjectItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProjectItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.project_item_view, this);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lr_item);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ProjectItemView);
        initWidget(typedArray, linearLayout);
    }


    private void initWidget(TypedArray typedArray, LinearLayout view) {
        //        setOrientation(VERTICAL);
        ImageView mImageView = (ImageView) view.findViewById(R.id.iv_item);
        TextView mTextView = (TextView) view.findViewById(R.id.tv_item);

        if (typedArray.hasValue(R.styleable.ProjectItemView_image)) {
            Drawable mDrawable = typedArray.getDrawable(R.styleable.ProjectItemView_image);
            mImageView.setBackground(mDrawable);
        }
        String text = typedArray.getString(R.styleable.ProjectItemView_promptText);
        mTextView.setText(text);

        int imageBottomMargin = (int) typedArray.getDimension(R.styleable.ProjectItemView_imageBottomMargin, 5f);

        LinearLayout.LayoutParams lp1 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, Gravity.CENTER_HORIZONTAL);
        lp1.bottomMargin = imageBottomMargin;
        mImageView.setLayoutParams(lp1);

        LinearLayout.LayoutParams lp2 = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER_HORIZONTAL);
        mTextView.setLayoutParams(lp2);

     /*   LayoutParams lp3 = new LayoutParams(0, LayoutParams.MATCH_PARENT, 1.0f);
        setLayoutParams(lp3);*/
        typedArray.recycle();
    }


}
