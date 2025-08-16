package com.text.new;

import android.content.Context;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;

import com.yousefh.rezone.R;

import java.util.HashMap;
import java.util.Map;

public class ClickableTextView extends AppCompatTextView {

    private Map<String, OnClickListener> clickableParts = new HashMap<>();
    private int clickableColor;

    public ClickableTextView(Context context) {
        super(context);
        init();
    }

    public ClickableTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ClickableTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        clickableColor = ContextCompat.getColor(getContext(), R.color.colorPrimary);
        setTextAlignment(TEXT_ALIGNMENT_CENTER);
    }

    /**
   * Set clickable words with listener for each word
   */
    public void setClickableParts(Map<String, OnClickListener> parts, String fullText, int normalColorRes) {
        clickableParts.clear();
        clickableParts.putAll(parts);

        int normalColor = ContextCompat.getColor(getContext(), normalColorRes);

        SpannableString spannable = new SpannableString(fullText);

        // Color of normal text
        setTextColor(normalColor);

        // Applay it for all clickable words
        for (Map.Entry<String, OnClickListener> entry : clickableParts.entrySet()) {
            String word = entry.getKey();
            OnClickListener listener = entry.getValue();

            int start = fullText.indexOf(word);
            if (start == -1) continue; // if word not include in sentence
            int end = start + word.length();

            // Color of clickable text
            spannable.setSpan(new ForegroundColorSpan(clickableColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

            // Click Action
            spannable.setSpan(new ClickableSpan() {
                @Override
                public void onClick(@NonNull View widget) {
                    if (listener != null) listener.onClick(widget);
                }
            }, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        setText(spannable);
        setMovementMethod(LinkMovementMethod.getInstance());
    }
}
