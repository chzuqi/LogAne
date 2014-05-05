/*
 * CLog.m
 * CLog
 *
 * Created by CZQ on 14-5-5.
 * Copyright (c) 2014年 czqsoft. All rights reserved.
 */

#import "CLog.h"

void CLogExtInitializer(void** extDataToSet, FREContextInitializer* ctxInitializerToSet, FREContextFinalizer* ctxFinalizerToSet) 
{
    *extDataToSet = NULL;
    *ctxInitializerToSet = &CLogContextInitializer;
    *ctxFinalizerToSet = &CLogContextFinalizer;
}

void CLogExtFinalizer(void* extData) 
{
    return;
}

void CLogContextInitializer(void* extData, const uint8_t* ctxType, FREContext ctx, uint32_t* numFunctionsToTest, const FRENamedFunction** functionsToSet)
{
    /* The following code describes the functions that are exposed by this native extension to the ActionScript code.
     */
    static FRENamedFunction func[] = 
    {
        MAP_FUNCTION(clog_to_console, NULL),
    };
    
    *numFunctionsToTest = sizeof(func) / sizeof(FRENamedFunction);
    *functionsToSet = func;
}

void CLogContextFinalizer(FREContext ctx)
{
    return;
}

ANE_FUNCTION(clog_to_console)
{
    NSString *text = getStringFromFREObject(argv[1]);
	NSLog(@"%@", text);
	return NULL;
}

NSString * getStringFromFREObject(FREObject obj)
{
    uint32_t length;
    const uint8_t *value;
    FREGetObjectAsUTF8(obj, &length, &value);
    return [NSString stringWithUTF8String:(const char *)value];
}

