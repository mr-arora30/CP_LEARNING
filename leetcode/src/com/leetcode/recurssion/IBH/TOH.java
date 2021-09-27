class TOH{
  public static void main(String args[]){
      toh("A","C","B",3);
    
  }

  public static void toh(String source, String destination, String helper, int plates){
    if(plates==1){
      System.out.println("Moving plate no : "+ plates + " from tower " + source + " to " + destination);
      return;
    }

     toh(source, helper, destination, plates-1);
     System.out.println("Moving plate no : "+ plates + " from tower " + source + " to " + destination);
     toh(helper,destination,source, plates-1);

  }
  
}