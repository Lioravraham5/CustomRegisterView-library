# CustomRegisterLibrary
CustomRegisterLibrary is a library for Android developers to easily integrate a customizable registration fragment into their applications.

<div style="display: flex;">
  <img src="https://github.com/Lioravraham5/customMapLibrary/assets/159531151/c3f1c551-b26f-41d0-a837-e20f0eab0cb9" alt="Image 2" style="width: 25%; height: 25%;">
  <img src="https://github.com/Lioravraham5/customMapLibrary/assets/159531151/adb97211-d2ab-451b-a5d3-cf652f993ef5" alt="Image 1" style="width: 25%; height: 25%;">
</div>

## Setup
Step 1. Add it in your root build.gradle at the end of repositories:
```
allprojects {
    repositories {
        // other repositories
        maven { url 'https://jitpack.io' }
    }
}
```

## Usage
To use the CustomRegisterLibrary, follow these steps:

1) **Initialize RegistrationDialogBuilder:** Create an instance of "RegistrationDialogBuilder" in your activity or fragment.
```
RegistrationDialogBuilder builder = new RegistrationDialogBuilder(context, getSupportFragmentManager(), R.id.registration_container);
```

2) **Add Registration Options:** Add desired registration options using "addXXXOption" methods.
```
builder.addNameOption(R.drawable.user, "Enter your name");
builder.addEmailOption(R.drawable.ic_mail, "Enter your email");
// Add more options as needed

```
3) **Customize Button:** Optionally, customize the registration button text and color.
```
builder.setButtonText("Sign Up");
builder.setButtonColor(Color.parseColor("#FF5983"));
```

4) **Set Completion Listener:** Set a listener to handle registration completion
```
builder.setOnRegistrationCompleteListener(new OnRegistrationCompleteListener() {
    @Override
    public void onRegistrationComplete() {
        // Handle registration completion
    }
});
```

5) **Show Registration Fragment:** Display the registration fragment by calling show().
```
builder.show();
```

## License
```
Copyright 2024 Lior Avraham

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

## Credits
CustomRegisterLibrary was created by Lior Avraham. 
