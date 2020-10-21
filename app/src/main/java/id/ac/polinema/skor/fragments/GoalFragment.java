package id.ac.polinema.skor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import id.ac.polinema.skor.R;
import id.ac.polinema.skor.databinding.FragmentGoalBinding;
import id.ac.polinema.skor.databinding.FragmentScoreBinding;
import id.ac.polinema.skor.models.GoalScorer;

/**
 * A simple {@link Fragment} subclass.
 */
public class GoalFragment extends Fragment {

	private String requestKey;
	private GoalScorer goalScorer;
	FragmentGoalBinding binding;


	public GoalFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.goalScorer = new GoalScorer();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goal, container, false);
		//binding.setFragment(this);
		requestKey = GoalFragmentArgs.fromBundle(getArguments()).getRequestKey();
		Button buttonSave = (Button) binding.buttonSave;
		buttonSave.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Bundle bundle = new Bundle();
				bundle.putParcelable(ScoreFragment.SCORER_KEY, goalScorer);
				getParentFragmentManager().setFragmentResult(requestKey, bundle);
				Navigation.findNavController(view).navigateUp();
			}
		});
		Button buttonCancel = (Button) binding.buttonCancel;
		buttonCancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Navigation.findNavController(view).navigateUp();
			}
		});
		return binding.getRoot();

	}

//	public void onSaveClicked(View view) {
//		Bundle bundle = new Bundle();
//		bundle.putParcelable(ScoreFragment.SCORER_KEY, goalScorer);
//		getParentFragmentManager().setFragmentResult(requestKey, bundle);
//		Navigation.findNavController(view).navigateUp();
//	}
//
//	public void onCancelClicked(View view) {
//		Navigation.findNavController(view).navigateUp();
//
//	}
}