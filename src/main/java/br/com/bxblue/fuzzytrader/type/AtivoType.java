package br.com.bxblue.fuzzytrader.type;

public enum AtivoType {

    ACAO("ACAO"),
    CRIPTOMOEDA("CRIPTOMOEDA");
  
    private String name;
  
    public String getName() {
      return this.name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    AtivoType(String name) {
      this.name = name;
    }
    
}