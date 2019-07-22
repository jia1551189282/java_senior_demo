public enum  CountryEnums {
    ONE(1,"��"),TWO(2,"κ"),THREE(3,"��"),FOUR(4,"��"),FIVE(5,"��"),SIX(6,"��");
    private Integer retCode;
    private String retMsg;

    CountryEnums(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }

    public static CountryEnums  forEachCountEnums(int index){
        for (CountryEnums count: values()
             ) {
            if(count.getRetCode() == index){
                return count;
            }

        }
        return null;
    }
}
