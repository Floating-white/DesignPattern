package ChainOfResponsibility.apply;


public class LeaveApprovalTest {
    public static void main(String[] args) {
        Leader teacher1 = new ClassAdviser();
        Leader teacher2 = new DepartmentHead();
        Leader teacher3 = new Dean();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);

        teacher1.handleRequest(9);
    }
}

// 抽象处理者
abstract class Leader {
    private Leader next;

    public Leader getNext() {
        return next;
    }

    public void setNext(Leader next) {
        this.next = next;
    }

    // 处理请求的方法
    public abstract void handleRequest(int leaveDays);

    public void transfer(int leaveDays) {
        if (getNext() != null) {
            getNext().handleRequest(leaveDays);
        } else {
            System.out.println("请假天数太多，没有人批准该假条！");
        }
    }
}

// 具体处理者1
class ClassAdviser extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays <= 2) {
            System.out.println("班主任批准您请假" + leaveDays + "天。");
        } else {
            transfer(leaveDays);
        }
    }
}

// 具体处理者2
class DepartmentHead extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 7) {
            System.out.println("系主任批准您请假" + leaveDays + "天。");
        } else {
            transfer(leaveDays);
        }
    }
}

class Dean extends Leader {
    @Override
    public void handleRequest(int leaveDays) {
        if (leaveDays < 14) {
            System.out.println("院长批准您请假" + leaveDays + "天。");
        } else {
            transfer(leaveDays);
        }
    }
}
