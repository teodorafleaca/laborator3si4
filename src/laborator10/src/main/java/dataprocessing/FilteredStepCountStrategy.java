package laborator10.src.main.java.dataprocessing;

import laborator10.src.main.java.storage.DataRepository;
import laborator10.src.main.java.storage.SensorData;

import java.util.List;

public class FilteredStepCountStrategy implements StepCountStrategy {

    private DataRepository dataRepository;

    public FilteredStepCountStrategy() {
        dataRepository = DataRepository.getInstance();
    }

    @Override
    public void consumeMessage(SensorData sample) {
        dataRepository.addSensorData(sample);
    }

    @Override
    public int getTotalSteps() {
        List<SensorData> allData = dataRepository.getRecords();
        int total = 0;

        for (int i = 0; i < allData.size(); i++) {
            SensorData current = allData.get(i);
            if (current.getStepsCount() <= 0) continue;

            long currentTime = current.getTimestamp();
            int stepsInLastMinute = 0;

            for (SensorData past : allData) {
                if (past.getTimestamp() >= currentTime - 60000 && past.getTimestamp() <= currentTime) {
                    stepsInLastMinute += past.getStepsCount();
                }
            }

            if (stepsInLastMinute <= 1000) {
                total += current.getStepsCount();
            }
        }

        return total;
    }

    @Override
    public String getStrategyDescription() {
        return "Filtered strategy: doar pasi pozitivi, max 1000 in ultimul minut";
    }


}
