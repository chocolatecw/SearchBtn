package com.choc.library.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.choc.library.R;
import com.choc.library.util.FindView;
import com.choc.library.util.UnitConvertUtil;

/**
 * Created by Administrator on 2017/3/13.
 */
public class SearchBtn extends LinearLayout {

    private static final int innerDefaultMargin = 8;
    private LinearLayout searchContainer;
    private View bottomBorderView;
    private int innerPadding;
    private int innerMargin;
    private int outerBackgroundColor;
    private boolean showBottomBorder;

    public SearchBtn(Context context) {
        this(context, null);
    }

    public SearchBtn(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchBtn(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs, R.styleable.SearchBtn, 0, 0);
        try {
            outerBackgroundColor = a.getColor(R.styleable.SearchBtn_android_background, Color.WHITE);
            innerMargin = a.getDimensionPixelOffset(R.styleable.SearchBtn_innerMargin, UnitConvertUtil.Dp2Px(context, innerDefaultMargin));
            showBottomBorder = a.getBoolean(R.styleable.SearchBtn_showBottomBorder, true);
        }finally {
            a.recycle();
        }

        View view = LayoutInflater.from(context).inflate(R.layout.search_btn, this, true);
        init(view);
    }

    private void init(View view) {
        searchContainer = FindView.findById(view, R.id.search_container);
        bottomBorderView = FindView.findById(view, R.id.bottom_border);
        if(!showBottomBorder) {
            bottomBorderView.setVisibility(View.INVISIBLE);
        }
        searchContainer.setBackgroundResource(R.drawable.search_bg_r);
        innerPadding = UnitConvertUtil.Dp2Px(getContext(), 3);
        searchContainer.setPadding(innerPadding, innerPadding, innerPadding, innerPadding);
        LinearLayout.LayoutParams layoutParams = (LayoutParams) searchContainer.getLayoutParams();
        layoutParams.setMargins(innerMargin, innerMargin, innerMargin, innerMargin-UnitConvertUtil.Dp2Px(getContext(), 1));
        searchContainer.setLayoutParams(layoutParams);

        setBackgroundColor(outerBackgroundColor);
        setPadding(0, 0, 0, 0);
    }

}
