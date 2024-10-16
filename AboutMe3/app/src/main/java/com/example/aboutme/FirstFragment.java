package com.example.aboutme;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.aboutme.databinding.FragmentFirstBinding;
import com.google.android.material.snackbar.Snackbar;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Navigate to the Hobbies Fragment
        binding.buttonHobbies.setOnClickListener(v ->
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment)
        );

        // Navigate to the Contact Fragment and show the "Going to Contact..." message
        binding.buttonContact.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Going to Contact...", Toast.LENGTH_SHORT).show();
            NavHostFragment.findNavController(FirstFragment.this)
                    .navigate(R.id.action_FirstFragment_to_ThirdFragment);
        });

        // Floating Action Button click to show the Snackbar with your email
        // Accessing FAB from the Activity (since the FAB is in activity_main.xml)
        requireActivity().findViewById(R.id.fab).setOnClickListener(v ->
                Snackbar.make(view, "Email: testuser@gmail.com", Snackbar.LENGTH_LONG)
                        .setAnchorView(v) // Anchor Snackbar to the FAB
                        .setAction("Action", null).show()
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

