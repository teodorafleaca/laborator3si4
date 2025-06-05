package laborator10.src.main.java.dataprocessing;

import laborator10.src.main.java.storage.DataRepository;
import laborator10.src.main.java.storage.SensorData;

import java.util.ArrayList;
import java.util.List;

public class BasicStepCountStrategy implements StepCountStrategy {

    private DataRepository dataRepository;
    public BasicStepCountStrategy() {
        this.dataRepository = DataRepository.getInstance();
    }
    @Override
    public void consumeMessage(SensorData sample) {
        dataRepository.addSensorData(sample);
    }

    @Override
    public int getTotalSteps() {
        return dataRepository.getRecords().stream().mapToInt(SensorData::getStepsCount).sum();
    }

    @Override
    public String getStrategyDescription() {
        return "Basic strategy: suma valorilor";
    }
}
