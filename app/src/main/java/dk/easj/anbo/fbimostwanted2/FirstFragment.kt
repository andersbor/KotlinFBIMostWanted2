package dk.easj.anbo.fbimostwanted2

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import dk.easj.anbo.fbimostwanted2.databinding.FragmentFirstBinding
import dk.easj.anbo.fbimostwanted2.models.CatalogViewModel
import dk.easj.anbo.fbimostwanted2.models.ItemAdapter

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private val catalogViewModel: CatalogViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/

        catalogViewModel.booksLiveData.observe(viewLifecycleOwner) { catalog ->
            Log.d("APPLEPIE", catalog.toString())

            val adapter = ItemAdapter(catalog.items) { position ->
                val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(position)
                findNavController().navigate(action /*R.id.action_FirstFragment_to_SecondFragment*/)
            }
            binding.recyclerView.layoutManager = LinearLayoutManager(activity)
            binding.recyclerView.adapter = adapter
        }

        catalogViewModel.errorMessageLiveData.observe(viewLifecycleOwner) { errorMessage ->
            binding.textViewError.text = errorMessage
        }

        binding.buttonNext.setOnClickListener {
            catalogViewModel.currentPage++ // TODO upper limit on currentPage
            catalogViewModel.reload()
        }

        binding.buttonPrev.setOnClickListener {
            if (catalogViewModel.currentPage == 1) {
                Snackbar.make(it, "First page", Snackbar.LENGTH_LONG).show()
                return@setOnClickListener
            }
            catalogViewModel.currentPage--
            catalogViewModel.reload()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}