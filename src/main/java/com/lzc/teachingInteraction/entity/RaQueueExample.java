package com.lzc.teachingInteraction.entity;

import java.util.ArrayList;
import java.util.List;

public class RaQueueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RaQueueExample() {
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

        public Criteria andQIdIsNull() {
            addCriterion("q_id is null");
            return (Criteria) this;
        }

        public Criteria andQIdIsNotNull() {
            addCriterion("q_id is not null");
            return (Criteria) this;
        }

        public Criteria andQIdEqualTo(String value) {
            addCriterion("q_id =", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotEqualTo(String value) {
            addCriterion("q_id <>", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThan(String value) {
            addCriterion("q_id >", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdGreaterThanOrEqualTo(String value) {
            addCriterion("q_id >=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThan(String value) {
            addCriterion("q_id <", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLessThanOrEqualTo(String value) {
            addCriterion("q_id <=", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdLike(String value) {
            addCriterion("q_id like", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotLike(String value) {
            addCriterion("q_id not like", value, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdIn(List<String> values) {
            addCriterion("q_id in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotIn(List<String> values) {
            addCriterion("q_id not in", values, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdBetween(String value1, String value2) {
            addCriterion("q_id between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQIdNotBetween(String value1, String value2) {
            addCriterion("q_id not between", value1, value2, "qId");
            return (Criteria) this;
        }

        public Criteria andQueueNameIsNull() {
            addCriterion("queue_name is null");
            return (Criteria) this;
        }

        public Criteria andQueueNameIsNotNull() {
            addCriterion("queue_name is not null");
            return (Criteria) this;
        }

        public Criteria andQueueNameEqualTo(String value) {
            addCriterion("queue_name =", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotEqualTo(String value) {
            addCriterion("queue_name <>", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameGreaterThan(String value) {
            addCriterion("queue_name >", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameGreaterThanOrEqualTo(String value) {
            addCriterion("queue_name >=", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLessThan(String value) {
            addCriterion("queue_name <", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLessThanOrEqualTo(String value) {
            addCriterion("queue_name <=", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameLike(String value) {
            addCriterion("queue_name like", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotLike(String value) {
            addCriterion("queue_name not like", value, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameIn(List<String> values) {
            addCriterion("queue_name in", values, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotIn(List<String> values) {
            addCriterion("queue_name not in", values, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameBetween(String value1, String value2) {
            addCriterion("queue_name between", value1, value2, "queueName");
            return (Criteria) this;
        }

        public Criteria andQueueNameNotBetween(String value1, String value2) {
            addCriterion("queue_name not between", value1, value2, "queueName");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Byte value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Byte value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Byte value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Byte value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Byte value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Byte value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Byte> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Byte> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Byte value1, Byte value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Byte value1, Byte value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andToUidIsNull() {
            addCriterion("to_uId is null");
            return (Criteria) this;
        }

        public Criteria andToUidIsNotNull() {
            addCriterion("to_uId is not null");
            return (Criteria) this;
        }

        public Criteria andToUidEqualTo(String value) {
            addCriterion("to_uId =", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotEqualTo(String value) {
            addCriterion("to_uId <>", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThan(String value) {
            addCriterion("to_uId >", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidGreaterThanOrEqualTo(String value) {
            addCriterion("to_uId >=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThan(String value) {
            addCriterion("to_uId <", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLessThanOrEqualTo(String value) {
            addCriterion("to_uId <=", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidLike(String value) {
            addCriterion("to_uId like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotLike(String value) {
            addCriterion("to_uId not like", value, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidIn(List<String> values) {
            addCriterion("to_uId in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotIn(List<String> values) {
            addCriterion("to_uId not in", values, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidBetween(String value1, String value2) {
            addCriterion("to_uId between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andToUidNotBetween(String value1, String value2) {
            addCriterion("to_uId not between", value1, value2, "toUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNull() {
            addCriterion("from_uid is null");
            return (Criteria) this;
        }

        public Criteria andFromUidIsNotNull() {
            addCriterion("from_uid is not null");
            return (Criteria) this;
        }

        public Criteria andFromUidEqualTo(String value) {
            addCriterion("from_uid =", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotEqualTo(String value) {
            addCriterion("from_uid <>", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThan(String value) {
            addCriterion("from_uid >", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidGreaterThanOrEqualTo(String value) {
            addCriterion("from_uid >=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThan(String value) {
            addCriterion("from_uid <", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLessThanOrEqualTo(String value) {
            addCriterion("from_uid <=", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidLike(String value) {
            addCriterion("from_uid like", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotLike(String value) {
            addCriterion("from_uid not like", value, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidIn(List<String> values) {
            addCriterion("from_uid in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotIn(List<String> values) {
            addCriterion("from_uid not in", values, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidBetween(String value1, String value2) {
            addCriterion("from_uid between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andFromUidNotBetween(String value1, String value2) {
            addCriterion("from_uid not between", value1, value2, "fromUid");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("cTime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("cTime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Integer value) {
            addCriterion("cTime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Integer value) {
            addCriterion("cTime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Integer value) {
            addCriterion("cTime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("cTime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Integer value) {
            addCriterion("cTime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Integer value) {
            addCriterion("cTime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Integer> values) {
            addCriterion("cTime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Integer> values) {
            addCriterion("cTime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Integer value1, Integer value2) {
            addCriterion("cTime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("cTime not between", value1, value2, "ctime");
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