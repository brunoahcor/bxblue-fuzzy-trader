package br.com.bxblue.fuzzytrader.type;

public enum SimboloType {

  AMAZONCOM_INC("AMZN"), 
  APPLE_INC("AAPL"), 
  FACEBOOK_INC("FB"), 
  JOHNSON_JOHNSON("JNJ"), 
  MASTERCARD_INC("MA"),
  MICROSOFT_CORP("MSFT"), 
  NETFLIX_INC("NFLX"), 
  NIKE_INC("NKE"), 
  THEWALTDISNEY_COMPANY("DIS"), 
  VISA_INV("V");

  private String name;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  SimboloType(String name) {
    this.name = name;
  }

  public static SimboloType obterPorSimbolo(String simbolo) {
    if (simbolo == null) return null;
    for (SimboloType s : SimboloType.values()) {
      if (s.name.equals(simbolo))
        return s;
    }
    return null;
  }

}