LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_RESOURCE_DIR := $(LOCAL_PATH)/res


LOCAL_CERTIFICATE := platform
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_PRIVATE_PLATFORM_APIS := true

LOCAL_MODULE_TAGS := optional

LOCAL_PACKAGE_NAME := ActivityViewDemo
LOCAL_PRODUCT_MODULE := true

LOCAL_SRC_FILES := $(call all-java-files-under, src)


LOCAL_USE_AAPT2 := true

LOCAL_STATIC_ANDROID_LIBRARIES += \
    android-support-constraint-layout

LOCAL_STATIC_JAVA_LIBRARIES := \
    android-support-constraint-layout-solver

include $(BUILD_PACKAGE)
