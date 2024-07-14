package com.example.customregisterscreen;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import java.util.List;

public class RegistrationFragment extends Fragment {

    private static String DEFAULT_BUTTON_TEXT = "Register";
    private static String DEFAULT_BUTTON_COLOR = "#42A5F5"; //blue 400 primary

    private List<RegistrationOption> options;
    private String buttonText = DEFAULT_BUTTON_TEXT;
    private int buttonColor = Color.parseColor(DEFAULT_BUTTON_COLOR);
    private OnRegistrationCompleteListener onRegistrationCompleteListener;

    public RegistrationFragment(List<RegistrationOption> options) {
        this.options = options;
    }

    public RegistrationFragment(List<RegistrationOption> options, String buttonText, int buttonColor) {
        this.options = options;
        this.buttonText = buttonText;
        this.buttonColor = buttonColor;
    }

    public RegistrationFragment(List<RegistrationOption> options, int buttonColor) {
        this.options = options;
        this.buttonColor = buttonColor;
    }

    public RegistrationFragment(List<RegistrationOption> options, String buttonText) {
        this.options = options;
        this.buttonText = buttonText;
    }

    public void setOnRegistrationCompleteListener(OnRegistrationCompleteListener onRegistrationCompleteListener) {
        this.onRegistrationCompleteListener = onRegistrationCompleteListener;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setButtonColor(int buttonColor) {
        this.buttonColor = buttonColor;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_registration, container, false); //inflate the dialog layaout (xml)
        LinearLayout layout = view.findViewById(R.id.registration_layout); //Finds the LinearLayout int the xml where the registration options will be added.

        for (RegistrationOption option : options) {
            View field = inflater.inflate(R.layout.item_registration_option, layout, false);

            ImageView icon = field.findViewById(R.id.option_icon);
            EditText editText = field.findViewById(R.id.option_edit_text);

            icon.setImageResource(option.getIconResId());
            editText.setHint(option.getHint());
            editText.setTag(option.getOptionType());

            layout.addView(field);
        }

        Button registerButton = createButtonProgrammatically();

        // Add the button to the layout
        layout.addView(registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateAllOptions()) {
                    //perform the callback
                    if(onRegistrationCompleteListener != null){
                        Log.d("RegistrationFragment", "All options are valid. Proceed with registration.");
                        onRegistrationCompleteListener.onRegistrationComplete();
                    }

                } else {
                    // Show error or handle invalid input
                    Log.d("RegistrationFragment", "Invalid input detected.");
                }
            }
        });

        return view;
    }

    private boolean validateAllOptions() {
        boolean allValid = true;
        for (RegistrationOption option : options) {
            EditText editText = getView().findViewWithTag(option.getOptionType());
            String userInput = editText.getText().toString();
            if (!isOptionValid(option, userInput, editText)) {
                allValid = false;
            }
        }
        return allValid;
    }

    private boolean isOptionValid(RegistrationOption option, String userInput, EditText editText) {
        boolean isValid;
        switch (option.getOptionType()) {
            case NAME:
                isValid = FormValidator.isValidName(userInput);
                if(!isValid)
                    editText.setError("Name must contains only letters, spaces, and hyphens");
                return isValid;

            case LAST_NAME:
                isValid = FormValidator.isValidName(userInput);
                if(!isValid)
                    editText.setError("Last name must contains only letters, spaces, and hyphens");
                return isValid;

            case CITY:
                isValid = FormValidator.isValidName(userInput);
                if(!isValid)
                    editText.setError("City must contains only letters, spaces, and hyphens");
                return isValid;

            case PASSWORD:
                isValid = FormValidator.isValidPassword(userInput);
                if(!isValid)
                    editText.setError("Password must contains at least 8 characters, one uppercase, one lowercase, one number");
                return isValid;

            case EMAIL:
                isValid = FormValidator.isValidEmail(userInput);
                if(!isValid)
                    editText.setError("Invalid Email");
                return isValid;

            case PHONE_NUMBER:
                isValid = FormValidator.isValidPhoneNumber(userInput);
                if(!isValid)
                    editText.setError("Invalid Phone number");
                return isValid;

            case ADDRESS:
                isValid = FormValidator.isValidAddress(userInput);
                if(!isValid)
                    editText.setError("Address must contains only letters, hyphens, numbers, and spaces)");
                return isValid;

            default:
                return true;
        }
    }

    private Button createButtonProgrammatically(){
        Button registerButton = new Button(getContext());
        registerButton.setText(buttonText);
        registerButton.setBackgroundColor(buttonColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL; // Center horizontally within the parent
        layoutParams.setMargins(16, 16, 16, 16); // Set margin

        registerButton.setLayoutParams(layoutParams);

        return registerButton;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}
