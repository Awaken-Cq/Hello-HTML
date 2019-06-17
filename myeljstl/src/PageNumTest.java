
public class PageNumTest {

	
	public static void main(String[] args) {
		
		int currentPage = 12;
				int cntPerPageGroup = 3;
				int startPage = -1;
				int endPage = -1;
				
		startPage = ((currentPage-1)/cntPerPageGroup)*cntPerPageGroup+1;
		endPage = startPage + cntPerPageGroup-1;
		//if(endPage>totalPage) {
	//		endPage = totalPage;
		//}
		
		if(currentPage%cntPerPageGroup == 2) {
			startPage = currentPage-2;
			endPage = currentPage;
			
		}else if(currentPage%cntPerPageGroup == 1) {
			startPage = currentPage-1;
			endPage = currentPage+1;
			
		}else if(currentPage%cntPerPageGroup == 0) {
			startPage = currentPage;
			endPage = currentPage+2;
		}
	
		System.out.println(startPage);
		System.out.println(endPage);
		
	}
}