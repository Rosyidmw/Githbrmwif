package com.example.githbrmwif.ui.settings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githbrmwif.data.model.Reminder
import com.example.githbrmwif.databinding.ActivitySettingsBinding
import com.example.githbrmwif.preference.ReminderPreference
import com.example.githbrmwif.receiver.AlarmReceiver

class SettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingsBinding
    private lateinit var reminder: Reminder
    private lateinit var alarmReceiver: AlarmReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val reminderPreference = ReminderPreference(this)
        if (reminderPreference.getReminder().isReminded){
            binding.switch1.isChecked = true
        } else {
            binding.switch1.isChecked = false
        }

        alarmReceiver = AlarmReceiver()

        binding.switch1.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                saveReminder(true)
                alarmReceiver.setRepeatingAlarm(this, "RepeatingAlarm", "11:59", "Github reminder")
            }else{
                saveReminder(false)
                alarmReceiver.cancelAlarm(this)
            }
        }
    }

    private fun saveReminder(state: Boolean) {
        val reminderPreference = ReminderPreference(this)
        reminder = Reminder()

        reminder.isReminded = state
        reminderPreference.setReminder(reminder)
    }
}