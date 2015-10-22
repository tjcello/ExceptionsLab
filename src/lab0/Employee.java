package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some point the
 * arguments to method parameters may not be valid.
 * <p>
 * For example, String arguments may be null or empty; other objects may be
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all arguments
 * are valid. The only exception is when any argument is acceptable based on
 * requirements. Fix the code below using if logic to validate method arguments
 * and throw IllegalArgumentException or a custom exception if the validation
 * fails.
 *
 * @author Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {

    public static final int MAX_VACATION_DAYS = 28;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) throws IllegalArgumentException {
        setFirstName(firstName);
        setLastName(lastName);
        setSsn(ssn);
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }

    public int getDaysVacation() {
        return daysVacation;
    }

    /**
     * Set vacation days for one employee
     *
     * @param daysVacation - a value greater than or equal to 0 but not more
     * than 30
     */
    public void setDaysVacation(int daysVacation) throws NumericRangeException {
        if (daysVacation < 0 || daysVacation > 30) {
            throw new NumericRangeException();
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name of a single employee
     *
     * @param firstName - optional, but may not contain more than 100 characters
     */
    public final void setFirstName(String firstName) throws IllegalArgumentException {
        try {
            int nameLength = firstName.length();

            char c = firstName.charAt(0);
            if (!Character.isUpperCase(c)) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException(npe);
        } catch (StringIndexOutOfBoundsException siobe) {
            throw new IllegalArgumentException(siobe);
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {

        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    // 333-33-3333
    // 333333333
    public void setSsn(String ssn) {
        if (ssn != null && (ssn.length() == 9 || ssn.length() == 11)) {
            String[] parts = ssn.split("-");
            if (parts.length != 3) {
                throw new IllegalArgumentException();
            }
            char[] chars = ssn.toCharArray();
            for (char c : chars) {
                if (!Character.isDigit(c)) {
                    throw new IllegalArgumentException();
                }
            }

        } else {
            throw new IllegalArgumentException();
        }
        this.ssn = ssn;
    }

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setFirstName(null);
        

    }

}
