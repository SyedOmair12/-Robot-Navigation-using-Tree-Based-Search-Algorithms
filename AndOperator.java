
public class AndOperator extends Operator {
    public AndOperator() {
    	sOperator = "&";
        newlevel = 2;
    }

    @Override
    public boolean booleanResult(boolean l, boolean r) {
        return l && r;
    }
}
