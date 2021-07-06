import java.util.LinkedList;

public class Polynomial {

    private LinkedList<Term> polynomial;

    // Default constructor
    public Polynomial()
    {
        this.polynomial = new LinkedList<Term>();
    }

    // Copy Constructor
    public Polynomial(Polynomial polynomial)
    {
        this.polynomial = new LinkedList<Term>();

        for (int i = 0; i < polynomial.getNumTerms(); i++)
        {
            this.polynomial.add(new Term(polynomial.getTerm(i)));
        }
    }

    // Add one Polynomial to another
    public void add(Polynomial other)
    {

        if(other.getNumTerms() == 0)
        {
            return;
        }

        for (int i = 0; i < other.getNumTerms(); i++)
        {
            addTerm(new Term(other.getTerm(i)));
        }

    }

    // Add a single term to a Polynomial
    public void addTerm(Term termToAdd)
    {
        int location = -1,
            addedCoefficient = 0;

        if (this.polynomial.size() == 0)
        {
            this.polynomial.add(termToAdd);
            return;
        }

        for(int i = 0; i < this.polynomial.size(); i++)
        {
            if (termToAdd.getExponent() == this.polynomial.get(i).getExponent())
            {
                location = i;
                addedCoefficient = this.polynomial.get(location).getCoefficient() + termToAdd.getCoefficient();
                this.polynomial.get(location).setCoefficient(addedCoefficient);
                break;
            }

            if (termToAdd.getExponent() > this.polynomial.get(i).getExponent())
            {
                location = i;
                this.polynomial.add(location, termToAdd);
                break;
            }

        }

        if (location == -1)
        {
            this.polynomial.add(termToAdd);
        }
    }

    // Remove a term from a polynomial at a certain index
    public void remove(int index)
    {
        this.polynomial.remove(index);
    }

    // Return the amount of terms in a polynomial
    public int getNumTerms()
    {
        return this.polynomial.size();
    }

    // Return a term at a certain index
    public Term getTerm(int index)
    {
        return polynomial.get(index);
    }

    // Clear a polynomial of all terms
    public void clear()
    {
        this.polynomial.clear();
    }

    // Display Polynomial as a String
    public String toString()
    {
        String poly = "";

        if (this.polynomial.isEmpty())
        {
            return "0";
        }

        for (int i = 0; i < this.polynomial.size(); i++)
        {
            poly += this.polynomial.get(i);
        }

        return poly.substring(1);
    }

}
