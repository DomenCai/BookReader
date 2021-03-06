package com.domencai.bookreader.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.domencai.bookreader.utils.BookManager;
import com.domencai.bookreader.utils.DrawUtils;

import java.util.List;

/**
 * 章节里面的每一页
 * Created by Domen、on 2017/11/21.
 */

public class PageView extends View {
    private TextPaint mPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    private List<String> mPageLines;
    private int mPageSize;
    private int mPageIndex;

    public PageView(Context context) {
        this(context, null);
    }

    public PageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void setLines(List<String> pageLines, int pageIndex, int pageSize) {
        mPageLines = pageLines;
        mPageIndex = pageIndex;
        mPageSize = pageSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mPageLines == null || mPageLines.isEmpty()) {
            return;
        }
        int textSize = BookManager.getInstance().getTextSize();
        int padding = DrawUtils.dp2px(16);
        float lineSpace = getLineSpace(getHeight() - padding * 3, textSize);
        mPaint.setColor(BookManager.getInstance().getTextColor());
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(textSize);
        float tempY = textSize + padding;
        int width = getWidth() - padding * 2;
        for (String line : mPageLines) {
            if (line.startsWith("\u3000\u3000") && tempY != textSize + padding) {
                tempY += lineSpace;
            }
            resetLetterSpacing(width, line);
            canvas.drawText(line, padding, tempY, mPaint);
            tempY += textSize + lineSpace;
        }

        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(DrawUtils.sp2px(12));
        resetLetterSpacing(width, "");
        String pageIndexInfo = mPageIndex + "/" + mPageSize;
        canvas.drawText(pageIndexInfo, getWidth() - padding, getHeight() - padding, mPaint);
    }

    private float getLineSpace(float pageHeight, float textSize) {
        if (mPageIndex == mPageSize) {
            return textSize / 2;
        }
        int spaceCount = 1;
        for (int i = 1; i < mPageLines.size(); i++) {
            spaceCount += mPageLines.get(i).startsWith("\u3000\u3000") ? 2 : 1;
        }
        return (pageHeight - textSize * mPageLines.size()) / spaceCount;
    }

    private void resetLetterSpacing(int width, String line) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPaint.setLetterSpacing(0);
            float lineWidth = mPaint.measureText(line);
            float ratio = (width - lineWidth) / width;
            if (ratio > 0 && ratio < 0.1f) {
                mPaint.setLetterSpacing(ratio);
            }
        }
    }
}
