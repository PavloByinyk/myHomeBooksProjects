package com.bignerdranch.android.photogallery;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by 1 on 25.07.2016.
 */
public class PhotoPageFragment extends Fragment {

    private static final String ARG_URI = "photo_page_url";
    private Uri mUri;
    private WebView mWebView;
    public static PhotoPageFragment newInstance(Uri uri) {
        Bundle args = new Bundle();
        args.putParcelable(ARG_URI, uri);
        PhotoPageFragment fragment = new PhotoPageFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUri = getArguments().getParcelable(ARG_URI);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             
                                     Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_page, container,
                false);
        mWebView = (WebView) v.findViewById
                (R.id.fragment_photo_pager_web_view);
        return v;
    }
}
