# investment-msa-service
## 프로젝트 설명
### 내용
* 투자에 도움을 주는 서비스 구현하자
* Micro Service Architecture를 이용하여 서비스를 구현
  
### 사용 기술 및 환경
* WSL2, JAVA 17, Gradle
* Spring Boot, JPA
* Spring Cloud Config: 환경 외부 설정을 위해서 사용
* Spring Cloud Gateway: 라우팅 및 통합 Swagger 문서 구성에 사용
* Spring Cloud Netflix: Eureka 서버를 통해 서비스 발견을 위해 사용

# Services
## cloud-config
* **PORT:8888**
* 구성 중앙관리를 위한 서버
* Git 방식을 사용하여 구성을 관리
  
## api-gateway
* **PORT:8765**
* 서비스 라우팅
* 통합 Swagger 문서(openapi 사용, '/' 접근시)
  
## naming-server
* **PORT:8761**
* Eureka Server, 서비스 등록 및 확인에 사용
  
## securities-service
* **PORT:8000**
* 증권 정보를 담당하는 서비스
* data.sql을 이용하여 초기 데이터 사용(20~24년의 1월 데이터)
### Entity
* StockInfo(Long id, String number, String name)
* StockPrice(Long id, String number, double price, LocalDate date)
### URLS
* (GET, POST) /stockinfo
* (GET) /stockinfo/{name}
* (PUT, DELETE) /stockinfo/{id}
* (GET, POST) /stockprice
* (GET) /stockprice/{number}
* (PUT, DELETE) /stockprice/{id}

## portfolio-service
* **PORT:8010**
* 포트폴리오를 담당하는 서비스
### Entity
* Portfolio(Long id, String name, List<PortfolioItem> items)
* PortfolioItem(Long id, String stcok, double weight, Portfolio portfolio)
### URLS
* (GET, POST) /portfolio
* (GET, PUT, DELETE) /portfolio/{id}
* (GET, POST) /portfolio/{id}/portfolioItem
* (GET) /portfolioItem
* (GET, PUT, DELETE) /portfolioItem/{id}

## portfolio-composition-service
* **PORT:8040**
* 포트폴리오를 구성해서 반환하는 서비스
* 주식명, 비중을 입력받아서 해당 정보에 Map(날짜, 가격)을 추가해서 반환
### DTO
* PortfolioCompositionInputDTO(List<PortfolioCompositionInputItemDTO> portfolioItemList)
* PortfolioCompositionInputItemDTO(String stock, double weight)
* PortfolioCompositionReturnDTO(List<PortfolioCompositionReturnItemDTO> portfolioCompositionReturnItemDTOList)
* PortfolioCompositionReturnItemDTO(String stock, Map<LocalDate, Double> price, double weight)
### URLS
* (POST) /portfolio-composition
### Service call
* securities-service
  
## calculator-service
* **PORT:8030**
* 각종 계산을 위한 서비스
* 수익률 계산, 총액 계산 등의 기능 
### DTO
* PortfolioRorDTO(List<Double> rorList, List<Double> weightList)
### URLS
* (POST) /calculator/ror/{sellPrice}/{buyPrice}
* (POST) /calculator/ror-list
* (POST) /calculator/portfolio-ror
* (POST) /calculator/total-ror
* (POST) /calculator/total-amount/{amount}/{ror}
  
## backtest-service
* **PORT:8020**
* 백테스트를 수행하는 서비스
* 가격, 비중으로 이루어진 포트폴리오를 받아서 백테스트를 수행
### DTO
* BacktestItemDTO(List<Double> priceList, double weight)
* BacktestResultDTO(List<List<Double>> itemRorList, List<Double> rorList, double totalRor, double maxRor, double minRor, double amount): itemRorList는 item별 수익률
* PortfolioRorDTO(List<Double> rorList, List<Double> weightList)
### URLS
* (POST) /backtest
### Service call
* calculator-service
  
## portfolio-backtest-service
* **PORT:8050**
* 포트폴리오를 구성해서 백테스트를 수행하고 결과를 반환하는 서비스
### DTO
* PortfolioBacktestInputDTO(String name, double amount, List<PortfolioBacktestInputItemDTO> portfolioItemList)
* PortfolioBacktestInputItemDTO(String stock, double weight)
* PortfolioBacktestReturnDTO(String name, PortfolioCompositionReturnDTO portfolioCompositionReturnDTO, BacktestResultDTO backtestResultDTO)
### URLS
* (POST) /portfolio-backtest
### Service call
* backtest-service
* portfolio-composition-service
