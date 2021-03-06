package edu.mills.freeingourselves;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

/**
 * Displays introductory information regarding testosterone.
 */
public class TestosteroneFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_testosterone, container, false);
        WebView tWebView = (WebView) view.findViewById(R.id.tWebView);
        tWebView.loadUrl("file:///android_asset/testosterone_intro_en.html");
        tWebView.setVerticalScrollBarEnabled(true);
        tWebView.setHorizontalScrollBarEnabled(true);

        Button learnMoreButton = (Button) view.findViewById(R.id.learnMoreButton);
        learnMoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment testosteroneFragment = new TestosteroneHealthOverviewFragment();
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame, testosteroneFragment);
                ft.addToBackStack(null);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }
        });
        return view;
    }
}
