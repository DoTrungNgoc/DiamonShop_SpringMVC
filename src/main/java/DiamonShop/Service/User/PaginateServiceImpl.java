package DiamonShop.Service.User;

import org.springframework.stereotype.Service;

import DiamonShop.Dto.PaginatesDto;

@Service
public class PaginateServiceImpl implements IPaginatesService{

	public PaginatesDto GetInfoPaginates(int totalData, int limit, int currentPage) {
		
		if (totalData == 0 )
			return new PaginatesDto(1, limit, 0, 0, 1);
		
		PaginatesDto paginate= new PaginatesDto();
		paginate.setLimit(limit);
		
		paginate.setTotalPage(caculateTotalPage(totalData,limit));
		paginate.setCurrentPage(checkCurrentPage(currentPage, paginate.getTotalPage()));
		
		paginate.setStart(findStart(paginate.getCurrentPage(),limit));
		paginate.setEnd(findEnd(paginate.getStart(),limit,totalData));
		
		return paginate;
	}
	
	private int findEnd(int start, int limit, int totalData) {
		return  start+limit> totalData ? totalData: (start+limit)-1;
	}

	private int findStart(int currentPage, int limit) {
		
		return ((currentPage - 1) * limit) +1;
	}

	private int caculateTotalPage(int totalData, int limit) {
		if (totalData%limit == 0)
			return totalData/limit;
		return totalData/limit + 1;
	}

	private int checkCurrentPage(int currentPage, int totalPage) {
		if (currentPage<1)
			return 1;
		if (currentPage > totalPage)
			return totalPage;
		return currentPage;
	}

}
