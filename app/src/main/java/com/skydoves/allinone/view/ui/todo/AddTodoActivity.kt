/*
 * Copyright (C) 2019 skydoves
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.skydoves.allinone.view.ui.todo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.skydoves.allinone.R
import com.skydoves.allinone.extension.overridePendingDown
import com.skydoves.allinone.extension.vm
import com.skydoves.allinone.models.ColorItem
import com.skydoves.allinone.view.adapter.recyclerView.TodoColorAdapter
import com.skydoves.allinone.view.viewholder.TodoColorViewHolder
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_add_todo.*
import kotlinx.android.synthetic.main.toolbar_default.*
import javax.inject.Inject

class AddTodoActivity : AppCompatActivity(), TodoColorViewHolder.Delegate {

  @Inject
  lateinit var viewModelFactory: ViewModelProvider.Factory
  private val viewModel by lazy { vm(viewModelFactory, AddTodoViewModel::class) }

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_add_todo)

    initializeUI()
  }

  private fun initializeUI() {
    toolbar_home.setOnClickListener { onBackPressed() }
    toolbar_title.text = getString(R.string.label_add_item)

    val colorAdapter = TodoColorAdapter(this, this)
    recyclerView_color.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
    recyclerView_color.adapter = colorAdapter
  }

  override fun onColorItemClick(color: ColorItem) {

  }

  override fun onBackPressed() {
    super.onBackPressed()
    overridePendingDown()
  }
}
