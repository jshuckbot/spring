package ru.gb.lesson_6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.annotation.Transformer;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.GenericTransformer;
import org.springframework.integration.file.FileWritingMessageHandler;
import org.springframework.integration.file.support.FileExistsMode;
import org.springframework.messaging.MessageChannel;

import java.io.File;

@Configuration
public class IntegrationConfig {
    @Bean
    public MessageChannel messageChannelInput() {
        return new DirectChannel();
    }
    
    @Bean
    public MessageChannel messageChannelWriteFile() {
        return new DirectChannel();
    }
    
    @Bean
    @Transformer(inputChannel = "messageChannelInput", outputChannel = "messageChannelWriteFile")
    public GenericTransformer<String, String> myTransformer() {
        return text -> {return text.toUpperCase();};
    }
    
    @Bean
    @ServiceActivator(inputChannel = "messageChannelWriteFile")
    public FileWritingMessageHandler myFileWritter() {
        FileWritingMessageHandler handler = new FileWritingMessageHandler(new File("./"));
        handler.setExpectReply(false);
        handler.setFileExistsMode(FileExistsMode.APPEND);
        handler.setAppendNewLine(true);
        return handler;
    }
}