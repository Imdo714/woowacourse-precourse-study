package controller;

import model.LottoList;
import model.Price;
import model.Rank;
import model.Winning;
import utlis.RandomNumber;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Map;

public class lottoController {

    private final InputView inputView;
    private final OutputView outputView;
    Price price = new Price();
    RandomNumber randomNumber = new RandomNumber();
    Winning winning = new Winning();

    public lottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(){
        getPriceAndValid(); // 금액 및 로또 갯수 계산

        LottoList lottoSaved = getLottoSaved();// 금액에 맞게 로또 번호 6개 뽑아서 Lotte 도메인에 저장

        getWinningLotto(); // 당첨 번호 입력 받아 검증

        getBonusNumber(); // 보너스 번호 입력 받아 검증

        Map<Rank, Integer> resultStats = getRankEnumMap(lottoSaved); // 당첨 번호 비교해서 통계 보여 줌

        getProfitRate(lottoSaved, resultStats); // 총 수익률 계산
    }

    private void getPriceAndValid() {
        while (true){
            try{
                price.validator(getPriceNumber()); // 천원 단위 검사 및 로또 갯수 계산
                break;
            } catch (IllegalArgumentException e){
                outputView.isExceptionMessage(e.getMessage());
            }
        }
        outputView.printPayment(price.getCount());
    }

    private String getPriceNumber() {
        outputView.printStartPrice(); // 금액 입력하라고 출력
        String getPrice = inputView.getWriteNumber();

        outputView.nextLinBlank(); // 한줄 띄우기
        return getPrice;
    }

    private LottoList getLottoSaved() {
        LottoList lottoList = randomNumber.generation(price.getCount()); // 구매한 로또 LottoList에 저장
        lottoList.printLottoNumbers(outputView);
        return lottoList;
    }

    private void getWinningLotto() {
        while (true){
            try{
                winning.validWinning(getWinningNumber());
                break;
            } catch (IllegalArgumentException e){
                outputView.isExceptionMessage(e.getMessage());
            }
        }
    }

    private String getWinningNumber() {
        outputView.printWinningNumber();
        String getWinning = inputView.getWriteNumber(); // 당첨 번호 입력

        outputView.nextLinBlank(); // 한줄 띄우기
        return getWinning;
    }

    private void getBonusNumber() {
        while (true){
            try{
                outputView.printBonusNumber();
                String writeNumber = inputView.getWriteNumber();
                winning.validBonus(writeNumber); // 보너스 볼 범위 숫자만 입력 하게 만듬
                break;
            } catch (IllegalArgumentException e){
                outputView.isExceptionMessage(e.getMessage());
            }
        }
    }

    private Map<Rank, Integer> getRankEnumMap(LottoList lottoSaved) {
        List<Rank> results = lottoSaved.matchAll(winning); // LottoList에 들어있는 구매한 로또 번호와들과 Winning에 들어있는 당첨 번호 비교

        Map<Rank, Integer> resultStats = lottoSaved.summarize(results); // EnumMap에 랭크 수량 계산 없으면 0 있으면 1씩 증가

        printDuplicationLottoStats(lottoSaved, resultStats);
        return resultStats;
    }

    private void printDuplicationLottoStats(LottoList lottoSaved, Map<Rank, Integer> resultStats) {
        outputView.printStatisticsMessage();
        lottoSaved.printStats(resultStats, outputView);
    }

    private void getProfitRate(LottoList lottoSaved, Map<Rank, Integer> resultStats) {
        int totalReward = lottoSaved.calculateTotalReward(resultStats); // 총 수익
        double rate = price.profitRate(totalReward);
        outputView.printProfitRate(rate);
    }

}
