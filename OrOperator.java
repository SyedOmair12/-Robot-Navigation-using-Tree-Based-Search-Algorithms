public class OrOperator extends Operator {
    public OrOperator() {
    	sOperator = "\\/";
        newlevel = 3;
    }

    @Override
    public boolean booleanResult(boolean l, boolean r) {
        return l || r;
    }
}