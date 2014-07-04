package cl.fullpay.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TribunalFragment extends Fragment {
	public static String ARG_TRIBUNAL_ID;

	public TribunalFragment(){}
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
			 Bundle savedInstanceState){
		 View rootView = inflater.inflate(R.layout.fragment_main,container,false);
		 return rootView;
	 }
}
