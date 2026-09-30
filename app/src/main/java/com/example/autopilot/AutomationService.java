package com.example.autopilot;
import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
public class AutomationService extends AccessibilityService {
    public static AutomationService instance;
    @Override public void onServiceConnected(){super.onServiceConnected();instance=this;}
    @Override public void onAccessibilityEvent(AccessibilityEvent e){}
    @Override public void onInterrupt(){}
    @Override public void onDestroy(){instance=null;super.onDestroy();}
}
