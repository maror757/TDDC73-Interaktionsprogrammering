package com.example.projekt1;

import android.content.Context;

public class PasswordStrengthCalculator{

    // Private variables
    private Context context;
    private int WEAK = 0;
    private int MEDIUM = 33;
    private int STRONG = 66;
    private int VERY_STRONG = 100;

    private int DEFAULT = 0;

    private int METHOD;
    public PasswordStrengthCalculator(Context cxt) {
        super();
        context = cxt;
        METHOD = 0;
    }

    public int getStrength(String password)
    {
        if(METHOD == DEFAULT)
            return defaultMethod(password);
        else {
            return 0;
        }
    }
    public void setMethod(int method)
    {
        METHOD = method;
    }

    private int defaultMethod(String password)
    {
        //--------REQUIREMENTS--------
        int REQUIRED_LENGTH = 6;
        int GOOD_LENGTH = 10;
        boolean REQUIRE_SPECIAL_CHARACTERS = true;
        boolean REQUIRE_DIGITS = true;
        boolean REQUIRE_LOWER_CASE = true;
        boolean REQUIRE_UPPER_CASE = true;

        int currentScore = 0;
        boolean sawUpper = false;
        boolean sawLower = false;
        boolean sawDigit = false;
        boolean sawSpecial = false;

        for (int i = 0; i < password.length(); i++)
        {
            char c = password.charAt(i);

            if (!sawSpecial && !Character.isLetterOrDigit(c))
            {
                currentScore += 1;
                sawSpecial = true;
            }
            else
            {
                if (!sawDigit && Character.isDigit(c))
                {
                    currentScore += 1;
                    sawDigit = true;
                }
                else
                {
                    if (!sawUpper || !sawLower)
                    {
                        if (Character.isUpperCase(c))
                            sawUpper = true;
                        else
                            sawLower = true;
                        if (sawUpper && sawLower)
                            currentScore += 1;
                    }
                }
            }
        }

        if (password.length() > REQUIRED_LENGTH)
        {
            if ((REQUIRE_SPECIAL_CHARACTERS && !sawSpecial) || (REQUIRE_UPPER_CASE && !sawUpper) || (REQUIRE_LOWER_CASE && !sawLower) || (REQUIRE_DIGITS && !sawDigit))
            {
                currentScore = 1;
            }
            else
            {
                currentScore = 2;
                if (password.length() > GOOD_LENGTH)
                {
                    currentScore = 3;
                }
            }
        }
        else
        {
            currentScore = 0;
        }

        switch (currentScore)
        {
            case 0:
                return WEAK;
            case 1:
                return MEDIUM;
            case 2:
                return STRONG;
            case 3:
                return VERY_STRONG;
            default:
        }

        return VERY_STRONG;
    }

}
