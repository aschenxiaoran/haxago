package com.xiaoran.infrastructure;

import com.xiaoran.infrastructure.command.SampleCommand;
import com.xiaoran.infrastructure.springs.CommandHandlerDefinitionRegistry;
import com.xiaoran.infrastructure.springs.SpringConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName CommandHandlerTests
 * Description 命令执行器测试
 * Author xiaoran
 * Date 2019/9/17 14:16
 * Version 1.0
 **/
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {SpringConfiguration.class})
@SpringBootTest(classes = {Application.class})
@Import(CommandHandlerDefinitionRegistry.class)
@ComponentScan(basePackages = "com.xiaoran.infrastructure")
public class CommandHandlerTests {

    @Autowired
    private CommandGateWay commandGateWay;

    @Test
    public void test_command_handle_annotation_excute() {

        SampleCommand command=new SampleCommand();
        command.setCode("覃爽爽");

        CommandResponse response=(CommandResponse) commandGateWay.sendAsyc(command);

        Assert.assertTrue(response.getSuccess());
    }
}
