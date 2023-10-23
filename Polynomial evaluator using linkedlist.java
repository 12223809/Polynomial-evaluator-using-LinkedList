import java.util.LinkedList;

class Polynomial {
    class Term {
        double coefficient;
        int exponent;

        Term(double coefficient, int exponent) {
            this.coefficient = coefficient;
            this.exponent = exponent;
        }
    }

    private LinkedList<Term> terms;
    private int degree;
    private int numTerms;

    public Polynomial() {
        terms = new LinkedList<>();
        degree = 0;
        numTerms = 0;
    }

    public void addTerm(double coefficient, int exponent) {
        if (coefficient != 0) {
            terms.add(new Term(coefficient, exponent));
            degree = Math.max(degree, exponent);
            numTerms++;
        }
    }

    public double evaluate(double xValue) {
        double result = 0.0;
        for (Term term : terms) {
            result += term.coefficient * Math.pow(xValue, term.exponent);
        }
        return result;
    }

    public void display() {
        StringBuilder polynomialString = new StringBuilder();
        for (Term term : terms) {
            if (term.coefficient > 0 && polynomialString.length() > 0) {
                polynomialString.append(" + ");
            } else if (term.coefficient < 0) {
                polynomialString.append(" - ");
            }
            polynomialString.append(Math.abs(term.coefficient));
            if (term.exponent > 0) {
                polynomialString.append("x");
                if (term.exponent > 1) {
                    polynomialString.append("^").append(term.exponent);
                }
            }
        }
        System.out.println("Polynomial: " + polynomialString.toString());
    }

    public static void main(String[] args) {
        Polynomial poly = new Polynomial();
        poly.addTerm(3, 2);
        poly.addTerm(-4, 1);
        poly.addTerm(1, 0);

        double xValue = 4.0;
        double result = poly.evaluate(xValue);

        poly.display();
        System.out.println("Evaluating at x = " + xValue + ": Result = " + result);
    }
}