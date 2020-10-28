package Model;


import java.io.Serializable;
import java.util.ArrayList;


public class Category implements Serializable {

    private static int categoryIDGenerator = 0;

    private int categoryID;
    private String categoryName;
    private ArrayList<User> responsibleUsers;
    private ArrayList<Category> subCategories;
    private Category parentCategory;
    private Money overallFinances;
    private ArrayList<Receivable> income;
    private ArrayList<Payment> expense;
    private Time categoryTimers;


    public Category(String categoryName,
                    User creatorUser,
                    Category parentCategory) {

        this.categoryName = categoryName;
        this.responsibleUsers = new ArrayList<User>();
        this.responsibleUsers.add(creatorUser);
        this.subCategories = new ArrayList<>();

        this.parentCategory = parentCategory;

        this.income = new ArrayList<Receivable>();
        this.expense = new ArrayList<Payment>();
        this.overallFinances = new Money();

        categoryID = categoryIDGenerator++;

        categoryTimers = Time.startCountingTime();
    }


    public String getCategoryID() {
        return Integer.toString(categoryID);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public ArrayList<Category> getSubCategories() { return subCategories; }


    public void AddSubCategory(String categoryName, User user, Category parentCategory)
    {


        subCategories.add(new Category(categoryName.toUpperCase(), user, parentCategory));
        System.out.println("Subcategory " + categoryName + " is successfully created.");
        categoryTimers.captureTimeOfModification();
    }

    public float getOverallFinances()
    {
        return overallFinances.getAmount();
    }

    public void BuySomething()
    {
        System.out.println("How much this thing costs?");

        Money price = new Money(Money.SpecifyPrice());

        Payment payment = Payment.MakeNewPayment(price);

        AddToExpenses(payment);

        SubstractFromOverall(price);

        categoryTimers.captureTimeOfModification();
    }



    public void ShowOutcomeHistory()
    {
        for (Payment payment : expense)
        {
            payment.ShowPaymentDetails();
        }
    }


    public void SellSomething()
    {
        System.out.println("How much this thing costs?");

        Money price =  new Money(Money.SpecifyPrice());

        Receivable receivable = Receivable.MakeNewReceivable(price);

        income.add(receivable);

        overallFinances.AddMoney(price);

        categoryTimers.captureTimeOfModification();
    }

    public void ShowIncomeHistory()
    {
        for (Receivable receivable : income)
        {
            receivable.ShowReceivableDetails();
        }
    }

    private void SubstractFromOverall(Money price) {
        overallFinances.SubtractMoney(price);
        categoryTimers.captureTimeOfModification();
    }

    private void AddToExpenses(Payment payment) {
        expense.add(payment);
        categoryTimers.captureTimeOfModification();
    }

    public Time getCategoryTimers() {
        return categoryTimers;
    }

    public String getDetails() {
        StringBuilder categoryInfo = new StringBuilder("Category: " + this.categoryName + "\nResponsible Users: ");

        for (User user : responsibleUsers) { categoryInfo.append(user.loginName + "  "); }

        categoryInfo.append("\n");

        for (Category category : this.subCategories) { categoryInfo.append(category.categoryName + "  "); }

        categoryInfo.append("\nCategoryCreated: " + categoryTimers.getTimeCreated() + "\n");

        return categoryInfo.toString();
    }

    @Override
    public String toString() {
        return this.categoryName;
    }
}
