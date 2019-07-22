public enum  CountryEnums {
    ONE(1,"º«"),TWO(2,"Îº"),THREE(3,"ÕÔ"),FOUR(4,"Æë"),FIVE(5,"³þ"),SIX(6,"Ñà");
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
