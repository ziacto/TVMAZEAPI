package com.lovoo.android.data.model.show


data class ShowDetails(
        val summary: String? = null,
        val image: Image? = null,
        val links: Links? = null,
        val premiered: String? = null,
        val rating: Rating? = null,
        val runtime: Int? = null,
        val weight: Int? = null,
        val language: String? = null,
        val type: String? = null,
        val url: String? = null,
        val officialSite: String? = null,
        val network: Any? = null,
        val schedule: Schedule? = null,
        val webChannel: WebChannel? = null,
        val genres: List<String?>? = null,
        val name: String? = null,
        val id: Int? = null,
        val externals: Externals? = null,
        val updated: Int? = null,
        val status: String? = null
)