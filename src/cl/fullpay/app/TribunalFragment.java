package cl.fullpay.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class TribunalFragment extends Fragment {
	public static String ARG_TRIBUNAL_ID;

	public TribunalFragment(){}
	
	 @Override
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
			 Bundle savedInstanceState){
		 View rootView = inflater.inflate(R.layout.fragment_main,container,false);
         //Set spinners initial option

         Spinner spinner = (Spinner)rootView.findViewById(R.id.spinner1);
         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
        	        R.array.stages_array, android.R.layout.simple_spinner_item);
    	// Specify the layout to use when the list of choices appears
    	adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    	// Apply the adapter to the spinner	
    	spinner.setAdapter(adapter);
    	spinner.setSelection(3);
    	Spinner spinner2 = (Spinner)rootView.findViewById(R.id.spinner2);
    	Spinner spinner3 = (Spinner)rootView.findViewById(R.id.spinner3);
    	Spinner spinner4 = (Spinner)rootView.findViewById(R.id.spinner4);
    	spinner2.setSelection(4);
    	spinner3.setSelection(1);
    	spinner4.setSelection(2);
		 return rootView;
	 }
}
