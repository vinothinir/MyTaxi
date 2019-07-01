package com.androiddemo.mytaxi;

import android.content.res.Resources;

import com.androiddemo.mytaxi.LoginActivity;
import com.androiddemo.mytaxi.R;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.AutoCompleteTextView;

import static org.hamcrest.core.AllOf.allOf;

public class LoginActivityTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule(LoginActivity.class);
    private Resources resources;
    private AutoCompleteTextView mEmailView;
    @Before
    public void init() {
       resources = mActivityRule.getActivity().getResources();
    }

    @Test
    public void testSuccessfulLOGIN() {

        //Find a view with id user_name and type "Chandler" on that view.
        onView(withId( R.id.user_name)).perform(typeText("foo@example.com"));

        //Find a view with has hint Password and type "sarcasm" as password.
        onView(withId(R.id.Password)).perform(typeText("hello"));

        //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an
        // exception.
        closeSoftKeyboard();

        //Find the LOGIN button and perform click().
        onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout))))
                .perform(click());

        //Assert that the textView of LOGIN TextView has been changed to Success.
       // String loginTxt = resources.getString(R.string.login_success);
        onView(allOf(withId(R.id.login_progress))).check
                (matches(withText("Login Success")));
    }

   /* @Test
    public void testFailedLOGIN() {

        //Find a view with id user_name and type "Ross" on that view.
        onView(withId(R.id.user_name)).perform(typeText(""));

        //Find a view with has hint Password and type "marriage" as password.
        onView(withId(R.id.Password)).perform(typeText("marriage"));

        //Close the keyword, otherwise LoginButton won't be visible to Espresso and it will throw an
        // exception.
        closeSoftKeyboard();

        //Find the LOGIN button and perform click().
        onView(allOf(withText("LOGIN"), isDescendantOfA(withId(R.id.linear_layout))))
                .perform(click());

        //Assert that the textView of LOGIN TextView has been changed to Success.
       // String loginTxt = resources.getString(R.string.error_field_required);
        String loginTxt="This field is required";
        mEmailView = (AutoCompleteTextView) mEmailView.findViewById(R.id.user_name);
        String loginTxt1 =mEmailView.getText().toString();
        if(loginTxt1.equalsIgnoreCase( loginTxt ) ){
            System.out.println("Test Passed : Error message is displayed");
        }
        //onView(allOf(withId(R.id.login_progress))).check
          //      (matches(withText(loginTxt)));
    }*/
}
