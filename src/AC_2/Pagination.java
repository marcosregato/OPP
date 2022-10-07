package AC_2;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
    private int page;
    private int perPage;
    private double totalPage;
    private List<BankAccount> originalArray;
    private List<BankAccount> paginationArray;

    public Pagination(int page, int perPage, List<BankAccount> bankAccounts) {
        this.setPage(page);
        this.setPerPage(perPage);
        this.setOriginalArray(bankAccounts);
        this.setTotalPage(Math.ceil(this.getOriginalArray().size() / this.getPerPage()));
    }

    public void update() {
        int start = ((page - 1) * getPerPage());
        int end = start + getPerPage();

        this.setPaginationArray(getOriginalArray().subList(start, end));
    }

    public void next() {
        this.setPage(this.getPage() + 1);
        if (this.getPage() > this.getTotalPage())
            this.setPage(this.getPage() - 1);
        this.update();
    }

    public void prev() {
        this.setPage(this.getPage() - 1);
        if (this.getPage() < this.getTotalPage())
            this.setPage(this.getPage() + 1);
        this.update();
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPerPage() {
        return this.perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public double getTotalPage() {
        return this.totalPage;
    }

    public void setTotalPage(double totalPage) {
        this.totalPage = totalPage;
    }

    public List<BankAccount> getOriginalArray() {
        return originalArray;
    }

    public void setOriginalArray(List<BankAccount> originalArray) {
        this.originalArray = originalArray;
    }

    public List<BankAccount> getPaginationArray() {
        return paginationArray;
    }

    public void setPaginationArray(List<BankAccount> paginationArray) {
        this.paginationArray = paginationArray;
    }

}
