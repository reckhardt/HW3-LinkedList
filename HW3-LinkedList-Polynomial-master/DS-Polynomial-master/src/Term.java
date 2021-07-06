public class Term implements Comparable<Term>, Cloneable {

    private int coefficient;
    private int exponent;

    // Default Constructor
    public Term()
    {
        this.coefficient = 1;
        this.exponent = 1;
    }

    // Full Constructor
    public Term(int coefficient, int exponent)
    {
        this.coefficient = coefficient;
        this.exponent = exponent;
    }

    // Copy Constructor
    public Term(Term other)
    {
        this.coefficient = other.coefficient;
        this.exponent = other.exponent;
    }

    // String Constructor
    public Term(String term)
    {
        if (term.contains("x"))
        {
            String[] splittedTerm = term.split("x");

            // If the term is a single x, no coefficient or exponent
            if (splittedTerm.length == 0)
            {
                this.coefficient = 1;
                this.exponent = 1;
                return;
            }

            // If the term does not have a specified exponent
            if (splittedTerm.length == 1)
            {
                if (splittedTerm[0].contains("-") && splittedTerm[0].length() == 1)
                {
                    this.coefficient = -1;
                }
                else if ((splittedTerm[0].contains("+") && splittedTerm[0].length() == 1))
                {
                    this.coefficient = 1;
                }
                else
                {
                    this.coefficient = Integer.parseInt(splittedTerm[0]);
                }

                this.exponent = 1;
                return;
            }

            String[] splittedExponent = splittedTerm[1].split("\\^");
            exponent = Integer.parseInt(splittedExponent[1]);

            // If the term does not have a specified coefficient
            if (splittedTerm[0].isEmpty())
            {
                this.coefficient = 1;
                return;
            }

            // If the term has both a specified coefficient and exponent
            if (splittedTerm[0].contains("-") && splittedTerm[0].length() == 1)
            {
                this.coefficient = -1;
            }
            else if (splittedTerm[0].contains("+") && splittedTerm[0].length() == 1)
            {
                this.coefficient = 1;
            }
            else
            {
                this.coefficient = Integer.parseInt(splittedTerm[0]);
            }

        }
        // If the term is a constant
        else
        {
            this.coefficient = Integer.parseInt(term);
            this.exponent = 0;
        }


    }

    public int getCoefficient()
    {
        return this.coefficient;
    }

    public int getExponent()
    {
        return this.exponent;
    }

    public void setCoefficient(int coefficient)
    {
        this.coefficient = coefficient;
    }

    public void setExponent(int exponent)
    {
        this.exponent = exponent;
    }

    public void setAll(int coefficient, int exponent)
    {
        this.coefficient = coefficient; this.exponent = exponent;
    }


    public int compareTo(Term other)
    {
        if (this.exponent == other.exponent)
            return 0;
        else if (this.exponent > other.exponent)
            return 1;

        return -1;
    }

    public String toString()
    {
        String term = "";

        if(coefficient != 0) {

            if (coefficient > 0)
                term += "+";

            if (coefficient == -1)
                term += "-";

            if (this.coefficient != 1 && this.coefficient != -1)
                term += coefficient;

            if (this.exponent != 0) {
                term += "x";

                if (this.exponent != 1) {
                    term += "^" + exponent;
                }
            }
        }

        return term;
    }

    @Override
    public Object clone()
    {
        return new Term(this.coefficient, this.exponent);
    }
}
