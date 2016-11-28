package com.navercorp.pinpoint.common.server.bo.codec.stat.v2;

import com.navercorp.pinpoint.common.server.bo.codec.stat.AgentStatCodec;
import com.navercorp.pinpoint.common.server.bo.codec.stat.AgentStatCodecTestBase;
import com.navercorp.pinpoint.common.server.bo.codec.stat.TestAgentStatFactory;
import com.navercorp.pinpoint.common.server.bo.stat.TransactionBo;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author HyunGil Jeong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class TransactionCodecV2Test extends AgentStatCodecTestBase<TransactionBo> {

    @Autowired
    private TransactionCodecV2 transactionCodecV2;

    @Override
    protected List<TransactionBo> createAgentStats(String agentId, long startTimestamp, long initialTimestamp) {
        return TestAgentStatFactory.createTransactionBos(agentId, startTimestamp, initialTimestamp);
    }

    @Override
    protected AgentStatCodec<TransactionBo> getCodec() {
        return transactionCodecV2;
    }

    @Override
    protected void verify(TransactionBo expected, TransactionBo actual) {
        Assert.assertEquals("agentId", expected.getAgentId(), actual.getAgentId());
        Assert.assertEquals("startTimestamp", expected.getStartTimestamp(), actual.getStartTimestamp());
        Assert.assertEquals("timestamp", expected.getTimestamp(), actual.getTimestamp());
        Assert.assertEquals("collectInterval", expected.getCollectInterval(), actual.getCollectInterval());
        Assert.assertEquals("sampledNewCount", expected.getSampledNewCount(), actual.getSampledNewCount());
        Assert.assertEquals("sampledContinuationCount", expected.getSampledContinuationCount(), actual.getSampledContinuationCount());
        Assert.assertEquals("unsampledNewCount", expected.getUnsampledNewCount(), actual.getUnsampledNewCount());
        Assert.assertEquals("unsampledContinuationCount", expected.getUnsampledContinuationCount(), actual.getUnsampledContinuationCount());
    }
}
