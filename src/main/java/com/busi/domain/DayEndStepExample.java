package com.busi.domain;

import java.util.ArrayList;
import java.util.List;

public class DayEndStepExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DayEndStepExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStepNoIsNull() {
            addCriterion("STEP_NO is null");
            return (Criteria) this;
        }

        public Criteria andStepNoIsNotNull() {
            addCriterion("STEP_NO is not null");
            return (Criteria) this;
        }

        public Criteria andStepNoEqualTo(Integer value) {
            addCriterion("STEP_NO =", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotEqualTo(Integer value) {
            addCriterion("STEP_NO <>", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThan(Integer value) {
            addCriterion("STEP_NO >", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoGreaterThanOrEqualTo(Integer value) {
            addCriterion("STEP_NO >=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThan(Integer value) {
            addCriterion("STEP_NO <", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoLessThanOrEqualTo(Integer value) {
            addCriterion("STEP_NO <=", value, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoIn(List<Integer> values) {
            addCriterion("STEP_NO in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotIn(List<Integer> values) {
            addCriterion("STEP_NO not in", values, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoBetween(Integer value1, Integer value2) {
            addCriterion("STEP_NO between", value1, value2, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNoNotBetween(Integer value1, Integer value2) {
            addCriterion("STEP_NO not between", value1, value2, "stepNo");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNull() {
            addCriterion("STEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andStepNameIsNotNull() {
            addCriterion("STEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andStepNameEqualTo(String value) {
            addCriterion("STEP_NAME =", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotEqualTo(String value) {
            addCriterion("STEP_NAME <>", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThan(String value) {
            addCriterion("STEP_NAME >", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_NAME >=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThan(String value) {
            addCriterion("STEP_NAME <", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLessThanOrEqualTo(String value) {
            addCriterion("STEP_NAME <=", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameLike(String value) {
            addCriterion("STEP_NAME like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotLike(String value) {
            addCriterion("STEP_NAME not like", value, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameIn(List<String> values) {
            addCriterion("STEP_NAME in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotIn(List<String> values) {
            addCriterion("STEP_NAME not in", values, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameBetween(String value1, String value2) {
            addCriterion("STEP_NAME between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepNameNotBetween(String value1, String value2) {
            addCriterion("STEP_NAME not between", value1, value2, "stepName");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNull() {
            addCriterion("STEP_DESC is null");
            return (Criteria) this;
        }

        public Criteria andStepDescIsNotNull() {
            addCriterion("STEP_DESC is not null");
            return (Criteria) this;
        }

        public Criteria andStepDescEqualTo(String value) {
            addCriterion("STEP_DESC =", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotEqualTo(String value) {
            addCriterion("STEP_DESC <>", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThan(String value) {
            addCriterion("STEP_DESC >", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescGreaterThanOrEqualTo(String value) {
            addCriterion("STEP_DESC >=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThan(String value) {
            addCriterion("STEP_DESC <", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLessThanOrEqualTo(String value) {
            addCriterion("STEP_DESC <=", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescLike(String value) {
            addCriterion("STEP_DESC like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotLike(String value) {
            addCriterion("STEP_DESC not like", value, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescIn(List<String> values) {
            addCriterion("STEP_DESC in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotIn(List<String> values) {
            addCriterion("STEP_DESC not in", values, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescBetween(String value1, String value2) {
            addCriterion("STEP_DESC between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStepDescNotBetween(String value1, String value2) {
            addCriterion("STEP_DESC not between", value1, value2, "stepDesc");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andReturnFlagIsNull() {
            addCriterion("RETURN_FLAG is null");
            return (Criteria) this;
        }

        public Criteria andReturnFlagIsNotNull() {
            addCriterion("RETURN_FLAG is not null");
            return (Criteria) this;
        }

        public Criteria andReturnFlagEqualTo(Integer value) {
            addCriterion("RETURN_FLAG =", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagNotEqualTo(Integer value) {
            addCriterion("RETURN_FLAG <>", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagGreaterThan(Integer value) {
            addCriterion("RETURN_FLAG >", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagGreaterThanOrEqualTo(Integer value) {
            addCriterion("RETURN_FLAG >=", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagLessThan(Integer value) {
            addCriterion("RETURN_FLAG <", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagLessThanOrEqualTo(Integer value) {
            addCriterion("RETURN_FLAG <=", value, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagIn(List<Integer> values) {
            addCriterion("RETURN_FLAG in", values, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagNotIn(List<Integer> values) {
            addCriterion("RETURN_FLAG not in", values, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagBetween(Integer value1, Integer value2) {
            addCriterion("RETURN_FLAG between", value1, value2, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andReturnFlagNotBetween(Integer value1, Integer value2) {
            addCriterion("RETURN_FLAG not between", value1, value2, "returnFlag");
            return (Criteria) this;
        }

        public Criteria andTranNoIsNull() {
            addCriterion("TRAN_NO is null");
            return (Criteria) this;
        }

        public Criteria andTranNoIsNotNull() {
            addCriterion("TRAN_NO is not null");
            return (Criteria) this;
        }

        public Criteria andTranNoEqualTo(String value) {
            addCriterion("TRAN_NO =", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotEqualTo(String value) {
            addCriterion("TRAN_NO <>", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoGreaterThan(String value) {
            addCriterion("TRAN_NO >", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoGreaterThanOrEqualTo(String value) {
            addCriterion("TRAN_NO >=", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLessThan(String value) {
            addCriterion("TRAN_NO <", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLessThanOrEqualTo(String value) {
            addCriterion("TRAN_NO <=", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoLike(String value) {
            addCriterion("TRAN_NO like", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotLike(String value) {
            addCriterion("TRAN_NO not like", value, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoIn(List<String> values) {
            addCriterion("TRAN_NO in", values, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotIn(List<String> values) {
            addCriterion("TRAN_NO not in", values, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoBetween(String value1, String value2) {
            addCriterion("TRAN_NO between", value1, value2, "tranNo");
            return (Criteria) this;
        }

        public Criteria andTranNoNotBetween(String value1, String value2) {
            addCriterion("TRAN_NO not between", value1, value2, "tranNo");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}