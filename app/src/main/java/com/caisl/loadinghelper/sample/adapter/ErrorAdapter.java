package com.caisl.loadinghelper.sample.adapter;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.caisl.loadinghelper.LoadingHelper;
import com.caisl.loadinghelper.sample.R;

/**
 * @author caisl
 * @since 2019/5/18
 */
public class ErrorAdapter extends LoadingHelper.Adapter<ErrorAdapter.ErrorViewHolder> {

  public ErrorAdapter() {
  }

  @NonNull
  @Override
  public ErrorViewHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
    return new ErrorViewHolder(inflater.inflate(R.layout.loading_layout_error, parent, false));
  }

  @Override
  public void onBindViewHolder(@NonNull final ErrorViewHolder holder) {

  }

  public class ErrorViewHolder extends LoadingHelper.ViewHolder {
    private TextView mTvErrorText;

    public ErrorViewHolder(@NonNull View rootView) {
      super(rootView);
      mTvErrorText = rootView.findViewById(R.id.tv_error_text);
      rootView.findViewById(R.id.btn_reload).setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          if (retryTask != null) {
            retryTask.run();
          }
        }
      });
    }

    public void setErrorText(String errorText) {
      if (TextUtils.isEmpty(errorText)) {
        return;
      }
      mTvErrorText.setText(errorText);
    }

  }
}