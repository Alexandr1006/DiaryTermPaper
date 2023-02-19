package task;

public enum TaskPeriodcity {
    WEEKLY{
        @Override
        public Task newTask() {
            return new WeeklyTask();
        }
    },
    MONTHLY{
        @Override
        public Task newTask() {
            return new MonthlyTask();
        }
    },
    DAILY{
        @Override
        public Task newTask() {
            return new DailyTask();
        }
    },
    YEARLY{
        @Override
        public Task newTask() {
            return new YearlyTask();
        }
    },
    ONETIME{
        @Override
        public Task newTask() {
            return new OneTimeTask();
        }
    };
    public abstract Task newTask();
}

